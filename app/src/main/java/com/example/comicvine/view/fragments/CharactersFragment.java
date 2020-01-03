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
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.IssuesAllLinearAdapter;
import com.example.comicvine.view.adapter.SeriesAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends Fragment {

    RecyclerView recyclerView;
    IssuesAllLinearAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_characters, container, false);

        recyclerView=view.findViewById(R.id.characters_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
        viewModel.getGetAllSeries().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                adapter=new IssuesAllLinearAdapter(issuesResults,getContext());
                recyclerView.setAdapter(adapter);
            }
        });

        return view;
    }

}
