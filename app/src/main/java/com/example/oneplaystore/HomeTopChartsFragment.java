package com.example.oneplaystore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeTopChartsFragment extends Fragment {

    public HomeTopChartsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
        adapter.addFragment(new TopFreeAppsfragment(), "TOP FREE APPS");
        adapter.addFragment(new TopFreeAppsfragment(), "TOP FREE GAMES");
        adapter.addFragment(new TopFreeAppsfragment(), "TOP GROSSING");
        adapter.addFragment(new TopFreeAppsfragment(), "TRENDING");
        viewPager.setAdapter(adapter);
    }
}
