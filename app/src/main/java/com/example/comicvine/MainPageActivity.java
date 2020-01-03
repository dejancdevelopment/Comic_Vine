package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.comicvine.view.adapter.ViewPagerAdapter;
import com.example.comicvine.view.fragments.CharactersFragment;
import com.example.comicvine.view.fragments.SeriesFragment;
import com.example.comicvine.view.fragments.IssuesFragment;
import com.example.comicvine.view.fragments.MoviesFragment;
import com.example.comicvine.view.fragments.StoriesFragment;
import com.google.android.material.tabs.TabLayout;

public class MainPageActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.view_pager_);
        tabLayout=findViewById(R.id.tab_layout_main);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),0);

        adapter.addFragment(new IssuesFragment(),"ISSUES");
        adapter.addFragment(new CharactersFragment(),"CHARACTERS");
        adapter.addFragment(new StoriesFragment(),"STORIES");
        adapter.addFragment(new SeriesFragment(),"SERIES");
        adapter.addFragment(new MoviesFragment(),"MOVIES");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
