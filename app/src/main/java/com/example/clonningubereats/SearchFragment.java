package com.example.clonningubereats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.modelClass.SearchModel;
import com.example.clonningubereats.modelClass.SearchSingleModel;
import com.example.clonningubereats.utils.search_fragments.SearchListImageAdapter;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    private RecyclerView mSearchRview;
    private Toolbar mSearchTT;
    private EditText mSearchEtext;
    private TextView mSearchDelete;
    private SearchListImageAdapter adapter;
    private ArrayList<SearchModel> mlist;
    private ArrayList<SearchSingleModel> imageList;

    public static String[] images = {
            "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        initialize(view);

            adapterSet();

        mSearchRview = view.findViewById(R.id.searchRview);
        mSearchEtext = view.findViewById(R.id.searchEtext);
//        mSearchDelete = view.findViewById(R.id.searchDelete);
        mlist = new ArrayList<>();
        imageList = new ArrayList<>();

        adapter = new SearchListImageAdapter(mlist, getActivity());
        mSearchRview.hasFixedSize();
        mSearchRview.setLayoutManager(new LinearLayoutManager(getActivity()));

        imageList.add(new SearchSingleModel("flower1", images[1]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[1]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));
        imageList.add(new SearchSingleModel("flower1", images[0]));

        mlist.add(new SearchModel("Top Category", imageList));

        mlist.add(new SearchModel("Top Category", imageList));
        mSearchRview.setAdapter(adapter);


        return view;
    }

    private void adapterSet() {

    }


    private void initialize(View view) {

    }




}
