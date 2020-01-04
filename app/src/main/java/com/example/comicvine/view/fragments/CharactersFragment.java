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
import com.example.comicvine.view.adapter.CharactersAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends Fragment {

   private RecyclerView recyclerView;
   private CharactersAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_characters, container, false);

        recyclerView=view.findViewById(R.id.characters_recycler_view);

        VineViewModel viewModel=ViewModelProviders.of(this).get(VineViewModel.class);
        viewModel.getGetAllCharacters().observe(this, new Observer<List<ResultsByCharacters>>() {
            @Override
            public void onChanged(List<ResultsByCharacters> resultsByCharacters) {

                adapter=new CharactersAdapter(resultsByCharacters,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });

            return view;
    }
}
