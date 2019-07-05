package com.example.clonningubereats;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.modelClass.DecisionModel;
import com.example.clonningubereats.modelClass.ImageObjects;
import com.example.clonningubereats.modelClass.MainModel;
import com.example.clonningubereats.modelClass.RestroPOJOsingle;
import com.example.clonningubereats.utils.home_adapters.MainAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ArrayList<MainModel> list;
    private ArrayList<RestroPOJOsingle> innerList;
    private ArrayList<ImageObjects> imageObjects;
    private String[] images = {
            "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"
    };
    //sfasfaf
    private static final String TAG = "HomeFragment1";

    private MainAdapter adapter;
    private RecyclerView mMainRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        DecisionModel model = new DecisionModel();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mMainRecyclerView = view.findViewById(R.id.mainRecyclerView);


        imageObjects = new ArrayList<>();
        imageObjects.add(new ImageObjects("https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        imageObjects.add(new ImageObjects("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        imageObjects.add(new ImageObjects("https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"));



        innerList = new ArrayList<>();
        innerList.add(new RestroPOJOsingle("1234", images[1],"Restro1", "images","12:20" ,"4.1"));
        innerList.add(new RestroPOJOsingle("2345", images[1],"Restro2", "images","12:20" ,"4.2"));
        innerList.add(new RestroPOJOsingle("3456", images[1],"Restro3", "images","12:20" ,"4.3"));
        innerList.add(new RestroPOJOsingle("4567", images[2],"Restro4", "images","12:20" ,"4.4"));
        innerList.add(new RestroPOJOsingle("5678", images[1],"Restro5", "images","12:20" ,"4.5"));
        Log.d(TAG, "lists: "+innerList.size());

        list = new ArrayList<>();

        list.add(new MainModel(0000, imageObjects));
        list.add(new MainModel(2222, "qwerty", innerList ));
        list.add(new MainModel(1111, "12345", images[0],"Rest1", "desss", "23:12", "4.3"));
        list.add(new MainModel(1111, "12345", images[0],"Rest1", "desss", "23:12", "4.3"));
        list.add(new MainModel(2222, "qwerty", innerList ));





        adapter = new MainAdapter( getActivity(), list);
        mMainRecyclerView.hasFixedSize();
        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));





        Log.d(TAG, "onCreateView: "+model.lists().size());



        mMainRecyclerView.setAdapter(adapter);
        return view;
    }



}





