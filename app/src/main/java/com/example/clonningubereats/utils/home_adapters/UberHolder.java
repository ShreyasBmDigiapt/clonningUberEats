package com.example.clonningubereats.utils.home_adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.clonningubereats.R;

public class UberHolder {

    public static class RestroCardHolder extends RecyclerView.ViewHolder {

        public ImageView mRestroCardImage;
        public TextView mRestroCardTitl, mRestroCardDes, mRestroCardTimming, mRestroCardRating;
        public CardView mRestroCardView;

        public RestroCardHolder(@NonNull View itemView) {
            super(itemView);
            mRestroCardTitl = itemView.findViewById(R.id.restroCardTitle);
            mRestroCardDes = itemView.findViewById(R.id.restroCardDes);
            mRestroCardImage = itemView.findViewById(R.id.restroCardImage);
            mRestroCardTimming = itemView.findViewById(R.id.restroCardTime);
            mRestroCardRating = itemView.findViewById(R.id.restroCardRating);
            mRestroCardView = itemView.findViewById(R.id.restroCardView);
        }
    }

    public static class  Holder extends RecyclerView.ViewHolder {

        public TextView title;
        public RecyclerView mRecyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.foodTitle);
            mRecyclerView = itemView.findViewById(R.id.foodRecyclerView);
        }
    }

    public static  class ViewPagerImage extends RecyclerView.ViewHolder {
        public ViewPager mViewPager;

        public ViewPagerImage(@NonNull View itemView) {
            super(itemView);

            mViewPager = itemView.findViewById(R.id.homeViewPager);

            //anything to do with viewPager
        }
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {

        public ImageView mCategoryImage;
        public TextView mCategoryText;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            mCategoryImage = itemView.findViewById(R.id.categoryImage);
            mCategoryText = itemView.findViewById(R.id.categoryText);
        }
    }

    public  static class WholeCategoryHolder extends RecyclerView.ViewHolder {

        public TextView mCategoryTitle;
        public RecyclerView mCategoryRV;

        public WholeCategoryHolder(@NonNull View itemView) {
            super(itemView);

            mCategoryTitle = itemView.findViewById(R.id.categoryTitle);
            mCategoryRV = itemView.findViewById(R.id.categoryRecyclerView);
        }
    }


}
