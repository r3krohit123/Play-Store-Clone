package com.example.oneplaystore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class fragment_top_charts extends Fragment {


    public fragment_top_charts() {
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
        View view = inflater.inflate(R.layout.fragment_top_charts, container, false);

        ViewPager viewPager = view.findViewById(R.id.vp_app_list);
        setupViewPager(viewPager);

        TabLayout subTabLayout = view.findViewById(R.id.tl_app_list);
        subTabLayout.setupWithViewPager(viewPager);

        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager());
        adapter.addFragment(new fragment_top_free_apps(), "TOP FREE APPS");
        adapter.addFragment(new fragment_top_free_apps(), "TOP FREE GAMES");
        adapter.addFragment(new fragment_top_free_apps(), "TOP GROSSING");
        adapter.addFragment(new fragment_top_free_apps(), "TRENDING");
        viewPager.setAdapter(adapter);
    }
}