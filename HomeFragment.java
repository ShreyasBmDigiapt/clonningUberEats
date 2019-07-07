package com.example.clonningubereats;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.clonningubereats.modelClass.DecisionModel;
import com.example.clonningubereats.modelClass.ImageObjects;
import com.example.clonningubereats.modelClass.MainModel;
import com.example.clonningubereats.modelClass.RestroPOJOsingle;
import com.example.clonningubereats.utils.home_adapters.MainAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseFirestore mDb;
    private FirebaseUser user;

    private ArrayList<MainModel> list;
    private ArrayList<RestroPOJOsingle> innerList;
    private ArrayList<ImageObjects> imageObjects;
    private SwipeRefreshLayout mMainSWL;
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

        //SWL
        mMainSWL = view.findViewById(R.id.mainSWL);
        mMainSWL.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        //firebase
        auth = FirebaseAuth.getInstance();
        mDb = FirebaseFirestore.getInstance();

        //list
        list = new ArrayList<>();
        innerList = new ArrayList<>();

        //viewpager
        mMainRecyclerView = view.findViewById(R.id.mainRecyclerView);

//        innerList = new ArrayList<>();
//        innerList.add(new RestroPOJOsingle("1234", images[1],"Restro1", "images","12:20" ,"4.1"));
//        innerList.add(new RestroPOJOsingle("2345", images[1],"Restro2", "images","12:20" ,"4.2"));
//        innerList.add(new RestroPOJOsingle("3456", images[1],"Restro3", "images","12:20" ,"4.3"));
//        innerList.add(new RestroPOJOsingle("4567", images[2],"Restro4", "images","12:20" ,"4.4"));
//        innerList.add(new RestroPOJOsingle("5678", images[1],"Restro5", "images","12:20" ,"4.5"));
//        Log.d(TAG, "lists: "+innerList.size());
//
//        list = new ArrayList<>();
//

//        list.add(new MainModel(2222, "qwerty", innerList ));
//        list.add(new MainModel(1111, "12345", images[0],"Rest1", "desss", "23:12", "4.3"));
//        list.add(new MainModel(1111, "12345", images[0],"Rest1", "desss", "23:12", "4.3"));
//        list.add(new MainModel(2222, "qwerty", innerList ));

        mMainRecyclerView.hasFixedSize();
        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Log.d(TAG, "onCreateView: "+list.size());

        adapter = new MainAdapter( getActivity(), list);
        mMainRecyclerView.setAdapter(adapter);
        //refresh
        getData();
        return view;
    }

    private void getData() {
        list.clear();
        adapter.notifyDataSetChanged();

        imageObjects = new ArrayList<>();
        imageObjects.add(new ImageObjects("https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        imageObjects.add(new ImageObjects("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
        imageObjects.add(new ImageObjects("https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529__340.jpg"));
        list.add(new MainModel(0000, imageObjects));

        getInnerData("Recommended dished");
        getInnerData("new on uber eats");
        getInnerData("popular near me");


        Log.d(TAG, "onCreateView: "+mDb.collection("restros").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "onComplete: "+task.getResult().getDocuments().toString());
                    List<DocumentSnapshot> document = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : document) {
                        list.add(new MainModel(1111, doc.getId(), doc.getString("thumImage"), doc.getString("title"), doc.getString("description"), doc.getString("timmings"), doc.getString("ratings")));

                        Log.d(TAG, "onComplete: "+list.get(0).getMainTitle());

                    }
                    mMainSWL.setRefreshing(false);
                    adapter.notifyDataSetChanged();
                }

            }
        }));
    }


    public void getInnerData(final String categoryName) {
        mDb.collection(categoryName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> innerDoc = task.getResult().getDocuments();
                    ArrayList<RestroPOJOsingle> kt = new ArrayList();
                    for (DocumentSnapshot doc: innerDoc) {
                        kt.add(new RestroPOJOsingle(doc.getId(),  doc.getString("thumImage"), doc.getString("title"), doc.getString("description"), doc.getString("timmings"), doc.getString("ratings")));
                    }
                    list.add(new MainModel(2222, categoryName ,kt));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


}





