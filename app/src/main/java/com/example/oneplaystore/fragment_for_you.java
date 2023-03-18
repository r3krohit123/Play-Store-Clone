package com.example.oneplaystore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fragment_for_you extends Fragment {

    private View view;
    private RecyclerView mainRecyclerView;
    public fragment_for_you() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_for_you, container, false);
        configureMainRecyclerView();

        return view;
    }

    private void configureMainRecyclerView() {
        mainRecyclerView = view.findViewById(R.id.for_you_recycler_view);
        mainRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mainRecyclerView.setLayoutManager(layoutManager);

        loadMainItemsData();
    }

    private void loadMainItemsData() {

        ArrayList<HomeItemModel> mArrayList = new ArrayList<>();

        if (getActivity() != null) {
            mArrayList.add(new HomeItemModel("", "", "special"));
            mArrayList.add(new HomeItemModel("New + Updated Games", "Selected games of the week", "normal"));
            mArrayList.add(new HomeItemModel("Recommended for you", "", "normal"));
            mArrayList.add(new HomeItemModel("Get Stuff Done", "", "normal"));
        }

        HomeItemAdapter homeItemAdapter = new HomeItemAdapter(mArrayList, getContext());
        mainRecyclerView.setAdapter(homeItemAdapter);

    }
}