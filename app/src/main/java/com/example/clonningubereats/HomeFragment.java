package com.example.clonningubereats;

import android.os.Bundle;
import android.os.Handler;
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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ArrayList<MainModel> list;
    private ArrayList<ImageObjects> imageList;

    //sfasfaf
    private static final String TAG = "HomeFragment1";
    private SwipeRefreshLayout mSRL;

    private MainAdapter adapter;
    private RecyclerView mMainRecyclerView;

    //firebase
    private FirebaseFirestore mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mMainRecyclerView = view.findViewById(R.id.mainRecyclerView);

        mDb = FirebaseFirestore.getInstance();
        mSRL = view.findViewById(R.id.SRL);

        list = new ArrayList<>();
        adapter = new MainAdapter(getActivity(), list);
        mMainRecyclerView.hasFixedSize();
        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mSRL.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getData();
            }
        });

        getData();
        mMainRecyclerView.setAdapter(adapter);
        return view;
    }

    private void getViewPager() {
        list.clear();
        adapter.notifyDataSetChanged();
        imageList = new ArrayList<>();
        mDb.collection("main_vp_images").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> snapshot = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : snapshot) {
                        imageList.add(new ImageObjects(doc.getString("vp_image")));
                    }
                    list.add(new MainModel(0000, imageList));
                    mSRL.setRefreshing(false);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getData() {
        list.clear();
        adapter.notifyDataSetChanged();

        getViewPager();
        getInnerList("Recommended dished");
        //single no rv
        mDb.collection("restros").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> snapshots = task.getResult().getDocuments();
                    for (DocumentSnapshot doc : snapshots) {
                        list.add(new MainModel(1111, doc.getId(), doc.getString("thumImage"), doc.getString("title"), doc.getString("description"), doc.getString("timmings"), doc.getString("ratings")));
                    }
                    mSRL.setRefreshing(false);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        getInnerList("new on uber eats");
        getInnerList("popular near me");
    }


    private void getInnerList(final String categoryName) {
        mDb.collection(categoryName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<DocumentSnapshot> documentSnapshots = task.getResult().getDocuments();
                ArrayList<RestroPOJOsingle> innerList = new ArrayList<>();
                for (DocumentSnapshot doc : documentSnapshots) {
                    innerList.add(new RestroPOJOsingle(doc.getId(), doc.getString("thumImage"), doc.getString("title"), doc.getString("description"), doc.getString("timmings"), doc.getString("ratings")));
                }
                list.add(new MainModel(2222, categoryName, innerList));
                adapter.notifyDataSetChanged();
            }
        });
    }


}





