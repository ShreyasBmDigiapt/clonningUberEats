package com.example.clonningubereats.modelClass;

import java.util.ArrayList;

public class MainModel {

    //views
    public static final int VIEWPAGER = 0000;
    public static final int SINGLE_RV = 1111;
    public static final int MUILTIPLE_RV = 2222;


    private int viewType;

    //ViewPager
   private ArrayList<ImageObjects> imageList;
   private int position;

    public MainModel(int viewType, ArrayList<ImageObjects> imageList) {
        this.viewType = viewType;
        this.imageList = imageList;
    }
    //Single recyclerView

    private String id, thumImage, title, description, timmings, ratings;

    public MainModel(int viewType, String id, String thumImage, String title, String description, String timmings, String ratings) {
        this.viewType = viewType;
        this.id = id;
        this.thumImage = thumImage;
        this.title = title;
        this.description = description;
        this.timmings = timmings;
        this.ratings = ratings;
    }

    //main recyclerView
    private String mainTitle;
    private ArrayList<RestroPOJOsingle> mList;


    public MainModel(int viewType, String mainTitle, ArrayList<RestroPOJOsingle> mList) {
        this.viewType = viewType;
        this.mainTitle = mainTitle;
        this.mList = mList;

    }
    //////////


    public ArrayList<ImageObjects> getImageList() {
        return imageList;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public ArrayList<RestroPOJOsingle> getmList() {
        return mList;
    }

    public int getViewType() {
        return viewType;
    }

    public String getId() {
        return id;
    }

    public String getThumImage() {
        return thumImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTimmings() {
        return timmings;
    }

    public String getRatings() {
        return ratings;
    }
}
