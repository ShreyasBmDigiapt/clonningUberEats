package com.example.clonningubereats.utils.offer_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.OfferMainImagePosition;
import com.example.clonningubereats.modelClass.OfferModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OfferRvAdapter extends RecyclerView.Adapter<OfferRvAdapter.OfferHolder> {

    private ArrayList<OfferModel> mList;
    private Context context;
    private int pos;

    public OfferRvAdapter(ArrayList<OfferModel> mList, Context context) {
        this.mList = mList;
        this.context = context;

    }

    @NonNull
    @Override
    public OfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.snipper_offer_items, parent,false);
        return new OfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferHolder holder, int position) {
        OfferModel model = mList.get(position);
        Picasso.get().load(model.getOfferImageUrl()).into(holder.mIvOfferImage);
        holder.mTvOfferTitle.setText(model.getOfferSingleTitle());
        holder.mTvOfferSubTitle.setText(model.getOfferSingleSubTitle());
        holder.mTvOfferTime.setText(model.getOfferSingleTime());
        holder.mTvOfferRating.setText(model.getOfferSingleRatings());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class OfferHolder extends RecyclerView.ViewHolder {

        private ImageView mIvOfferImage;
        private TextView mTvOfferTitle, mTvOfferSubTitle, mTvOfferTime, mTvOfferRating;

        public OfferHolder(@NonNull View itemView) {
            super(itemView);

            mIvOfferImage = itemView.findViewById(R.id.singleOfferImage);
            mTvOfferTitle = itemView.findViewById(R.id.singleofferTitle);
            mTvOfferSubTitle = itemView.findViewById(R.id.singleOfferSubtitle);
            mTvOfferTime = itemView.findViewById(R.id.offerSingleTime);
            mTvOfferRating = itemView.findViewById(R.id.offerSingleRating);


        }
    }
}
