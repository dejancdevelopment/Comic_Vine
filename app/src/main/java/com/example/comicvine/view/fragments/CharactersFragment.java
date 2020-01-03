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
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends Fragment {

    RecyclerView recyclerView;
    IssuesAllLinearAdapter adapter;

    //TODO
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_characters, container, false);

            return view;
    }

}
