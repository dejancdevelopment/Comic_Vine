package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comicvine.R;
import com.example.comicvine.view.adapter.ViewPagerAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_characters_detail, container, false);

        ViewPager viewPager=view.findViewById(R.id.viewPager);
        final ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager(),0);

        if(getArguments()!=null) {

            String name = getArguments().getString("NAME");

            PictureFragment pictureFragment = new PictureFragment();
            DescriptionFragment descriptionFragment=new DescriptionFragment();
            IssuesCharacterFragment issuesCharacterFragment=new IssuesCharacterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("NAME_", name);

            adapter.addFragment(pictureFragment, "");
            pictureFragment.setArguments(bundle);

            adapter.addFragment(descriptionFragment, "");
            descriptionFragment.setArguments(bundle);

            adapter.addFragment(issuesCharacterFragment,"");
            issuesCharacterFragment.setArguments(bundle);

            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    adapter.getItem(position);
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }

        return view;

    }

}
