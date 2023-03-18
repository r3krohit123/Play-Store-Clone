package com.example.oneplaystore;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    SearchView searchView;
    ImageView btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.mainViewPager);
        setupViewPager(viewPager);
        btnmenu=findViewById(R.id.btnmenu);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navigationView);
        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawerlayout);
          ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        MainActivity.this, drawer,
                        null,
                        R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
                drawer.addDrawerListener(toggle);
                toggle.syncState();

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setItemIconTintList(null);
       ImageView profileImageView = navigationView.getHeaderView(0).findViewById(R.id.profile_image);
        Glide.with(this)
                .load(R.drawable.cake)
                .into(profileImageView);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                DrawerLayout drawer = findViewById(R.id.drawerlayout);
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

//    private void loadFragment(Fragment fragment) {
//        FragmentManager fm= getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//
//        ft.add(R.id.container,fragment);
//        ft.commit();
//
//    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_home(), "Home");
        adapter.addFragment(new fragment_home(), "Games");
        adapter.addFragment(new fragment_home(), "Movies");
        adapter.addFragment(new fragment_home(), "Books");
        adapter.addFragment(new fragment_home(), "Music");
        viewPager.setAdapter(adapter);
    }
}