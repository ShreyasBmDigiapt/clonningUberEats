package com.example.clonningubereats.utils.search_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.SearchModel;
import com.example.clonningubereats.utils.home_adapters.UberHolder;

import java.util.ArrayList;

public class SearchListImageAdapter extends RecyclerView.Adapter<UberHolder.WholeCategoryHolder> {

    private ArrayList<SearchModel> mlist;
    private Context context;

    public SearchListImageAdapter(ArrayList<SearchModel> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public UberHolder.WholeCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_list, parent, false);
        return new UberHolder.WholeCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UberHolder.WholeCategoryHolder holder, int position) {
        SearchModel pojo = mlist.get(position);
        SearchSingleImageAdapter adapter = new SearchSingleImageAdapter(pojo.getSearchCategoryList(), context);
        holder.mCategoryTitle.setText(pojo.getSearchCategoryTitle());
        holder.mCategoryRV.hasFixedSize();
        holder.mCategoryRV.setLayoutManager(new GridLayoutManager(context, 2));
        holder.mCategoryRV.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
