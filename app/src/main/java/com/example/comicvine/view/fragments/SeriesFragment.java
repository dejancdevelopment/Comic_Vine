package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.comicvine.R;
import com.example.comicvine.data.model_series.ResultBySeries;
import com.example.comicvine.view.adapter.SeriesAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {

    RecyclerView recyclerView;
    SeriesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_episodes, container, false);

        recyclerView=view.findViewById(R.id.series_recycler_view);

        VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
        viewModel.getGetAllSeries().observe(this, new Observer<List<ResultBySeries>>() {
            @Override
            public void onChanged(List<ResultBySeries> resultBySeries) {

                adapter=new SeriesAdapter(resultBySeries,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });


        return view;
    }

}
