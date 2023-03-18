package com.example.oneplaystore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class fragment_home extends Fragment {

    private View view;
    private TabLayout subTabLayout;

    public fragment_home() {
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
        view = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager viewPager = view.findViewById(R.id.homeViewPager);
        setupViewPager(viewPager);

        subTabLayout = view.findViewById(R.id.sub_tabs);
        subTabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager());
        adapter.addFragment(new fragment_home(), "For You");
        adapter.addFragment(new fragment_top_charts(), "Top Charts");
        adapter.addFragment(new fragment_categories(), "Categories");
        adapter.addFragment(new fragment_for_you(), "Genres");
        adapter.addFragment(new HomeTopChartsFragment(), "Editor's Choice");





        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabOne.setText("For you");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(0)).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabTwo.setText("Top Charts");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_star, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(1)).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabThree.setText("Categories");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_category, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(2)).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFour.setText("Genres");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_circle_star, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(3)).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFive.setText("Editor's Choice");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_verified, 0, 0);
        Objects.requireNonNull(subTabLayout.getTabAt(4)).setCustomView(tabFive);
    }
}