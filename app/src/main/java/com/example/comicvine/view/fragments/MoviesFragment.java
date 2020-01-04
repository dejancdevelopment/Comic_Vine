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
import com.example.comicvine.data.model_movies.ResultByMovies;
import com.example.comicvine.data.model_movies.Studios;
import com.example.comicvine.data.model_movies.Writers;
import com.example.comicvine.view.adapter.MoviesAdapter;
import com.example.comicvine.view.adapter.StudiosAdapter;
import com.example.comicvine.view.adapter.WritersAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView,
            studios_recycler,
            writers_recycler;
    MoviesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_movies, container, false);

        recyclerView=view.findViewById(R.id.movies_recycler_view);
        studios_recycler=view.findViewById(R.id.studios_recycler);
        writers_recycler=view.findViewById(R.id.writers_recycler);

        VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
        viewModel.getGetAllMovies().observe(this, new Observer<List<ResultByMovies>>() {
            @Override
            public void onChanged(List<ResultByMovies> resultByMovies) {

                adapter=new MoviesAdapter(resultByMovies,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);

//                getWritersList(resultByMovies.get(0).getWriters());
            }
        });

        return view;
    }

    private void getStudiosList(List<Studios> list) {

        StudiosAdapter adapter = new StudiosAdapter(list,getContext());
        studios_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        studios_recycler.setAdapter(adapter);
    }

    private void getWritersList(List<Writers> list) {

        WritersAdapter adapter = new WritersAdapter(list, getContext());
        writers_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        writers_recycler.setAdapter(adapter);
    }

}
