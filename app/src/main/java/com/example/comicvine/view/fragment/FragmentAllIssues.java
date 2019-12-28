package com.example.comicvine.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.IssuesRecyclerView;
import com.example.comicvine.view.adapter.VenomRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAllIssues extends Fragment {

    private RecyclerView allIssuesRecycler;
    private IssuesRecyclerView adapterIssues;
    private VenomRecyclerView adapterVenom;

    public FragmentAllIssues() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_all_issues, container, false);

        allIssuesRecycler=view.findViewById(R.id.all_issues_recycler);
        allIssuesRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));

        IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);

        if(getArguments()!=null){

            String allIssues=getArguments().getString("ALL");

            if(allIssues.contains("allIssues")){

                viewModel.getGetAllIssues().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("allVenom")){

                viewModel.getGetAllVenom().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterVenom=new VenomRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterVenom);
                    }
                });
            }
        }
        return view;
    }
}
