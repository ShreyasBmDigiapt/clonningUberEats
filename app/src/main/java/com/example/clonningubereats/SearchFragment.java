package com.example.clonningubereats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonningubereats.modelClass.ImageObjects;
import com.example.clonningubereats.modelClass.SearchModel;
import com.example.clonningubereats.modelClass.SearchSingleModel;
import com.example.clonningubereats.utils.search_fragments.SearchListImageAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private RecyclerView mSearchRview;
    private Toolbar mSearchTT;
    private EditText mSearchEtext;
    private TextView mSearchDelete;
    private SearchListImageAdapter adapter;
    private ArrayList<SearchModel> mlist;
    private FirebaseFirestore mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        mSearchRview = view.findViewById(R.id.searchRview);
        mSearchEtext = view.findViewById(R.id.searchEtext);
        mDb = FirebaseFirestore.getInstance();
//        mSearchDelete = view.findViewById(R.id.searchDelete);
        mlist = new ArrayList<>();

        getData();
        adapter = new SearchListImageAdapter(mlist, getActivity());
        mSearchRview.hasFixedSize();
        mSearchRview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSearchRview.setAdapter(adapter);
        return view;
    }

    private void getData() {
        mDb.collection("search").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            ArrayList<SearchSingleModel> imageList;
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                List<DocumentSnapshot> snapshots = task.getResult().getDocuments();
                for (final DocumentSnapshot doc : snapshots) {
//                    mlist.add(new SearchModel(doc.getString("searchCategoryTitle"), imageList));
                    mDb.collection("search").document(doc.getId()).collection("category").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            imageList = new ArrayList<>();
                            List<DocumentSnapshot> snapshots1 = task.getResult().getDocuments();
                            for (DocumentSnapshot doc1 : snapshots1) {
                                imageList.add(new SearchSingleModel(doc1.getString("searchSingleImageText"), doc1.getString("searchSingleImageURl")));
                            }
                            mlist.add(new SearchModel(doc.getString("searchCategoryTitle"), imageList));
                            adapter.notifyDataSetChanged();
                        }
                });

            }
        }
    });
}
}
