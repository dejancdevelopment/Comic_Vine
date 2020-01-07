package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comicvine.R;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.view.adapter.adapter_characters.CharactersAdapter;
import com.example.comicvine.view.adapter.adapter_issues.IssuesAllRecyclerView;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IssuesCharacterFragment extends Fragment {


    public IssuesCharacterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_issues_character,container,false);

        final RecyclerView recyclerView=view.findViewById(R.id.character_detail_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        if (getArguments() != null) {

            String name = getArguments().getString("NAME_");

            VineViewModel viewModel = ViewModelProviders.of(this).get(VineViewModel.class);

            viewModel.getCharacterbyName(name);
            viewModel.getGetIssuesByName().observe(this, new Observer<List<IssuesResults>>() {
                @Override
                public void onChanged(List<IssuesResults> issuesResults) {

                    IssuesAllRecyclerView adapter=new IssuesAllRecyclerView(issuesResults,getContext());
                    recyclerView.setAdapter(adapter);
                }
            });

        }        return view;
    }

}
