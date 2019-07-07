package com.example.clonningubereats.modelClass;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DecisionModel {

    private static final String TAG = "DecisionModel1";

    private ArrayList<RestroPOJOsingle> innerList;
    public ArrayList imageList;

    public static String[] images = {
            "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"
    };

    public List imagesViewPager() {
        imageList = new ArrayList();
        imageList.add(images[0]);
        imageList.add(images[1]);
        imageList.add(images[2]);

        return imageList;
    }


    public ArrayList<RestroPOJOsingle> lists() {
          innerList = new ArrayList<>();
        innerList.add(new RestroPOJOsingle("1234", images[0],"Restro1", "images","12:20" ,"4.1"));
        innerList.add(new RestroPOJOsingle("2345", images[2],"Restro2", "images","12:20" ,"4.2"));
        innerList.add(new RestroPOJOsingle("3456", images[1],"Restro3", "images","12:20" ,"4.3"));
        innerList.add(new RestroPOJOsingle("4567", images[2],"Restro4", "images","12:20" ,"4.4"));
        innerList.add(new RestroPOJOsingle("5678", images[1],"Restro5", "images","12:20" ,"4.5"));
        Log.d(TAG, "lists: "+innerList.size());
        return innerList;
    }



}
