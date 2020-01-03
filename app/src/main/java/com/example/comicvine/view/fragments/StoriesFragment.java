package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comicvine.R;
import com.example.comicvine.data.model_characters.ResultsByCharacters;
import com.example.comicvine.view.adapter.StoriesAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoriesFragment extends Fragment {

    RecyclerView recyclerView;
    StoriesAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_stories, container, false);

        recyclerView=view.findViewById(R.id.recycler_view_stories);


        VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
        viewModel.getGetAllStories().observe(this, new Observer<List<ResultsByCharacters>>() {
            @Override
            public void onChanged(List<ResultsByCharacters> resultsByCharacters) {

                adapter=new StoriesAdapter(resultsByCharacters,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });

        return view;
    }

}
