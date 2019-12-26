package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.IronManRecyclerView;
import com.example.comicvine.view.adapter.IssuesRecyclerView;
import com.example.comicvine.view.adapter.VenomRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.Collections;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {

    RecyclerView recyclerView,recyclerViewVenom,recyclerViewIron,recyclerViewWolverine ;
    IssuesRecyclerView adapterView;
    VenomRecyclerView venomAdapter;
    IronManRecyclerView ironAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_issues);
        recyclerViewVenom=findViewById(R.id.recycler_view_venom);
        recyclerViewIron=findViewById(R.id.recycler_view_iron_man);
        recyclerViewWolverine=findViewById(R.id.recycler_view_wolverine);

        IssuesViewModel viewModel = ViewModelProviders
                .of(this)
                .get(IssuesViewModel.class);

        viewModel.getGetIssues().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewIssues(issuesResults);

            }
        });

        viewModel.getGetLiveDataDb().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                Collections.reverse(issuesResults);
                getRecyclerViewIssues(issuesResults);

            }
        });


        viewModel.getGetVenom().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewVenom(issuesResults);
            }
        });

        viewModel.getGetIronMan().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewIronMan(issuesResults);
            }
        });

        viewModel.getGetWolverine().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewWolverine(issuesResults);

            }
        });

    }

    private void getRecyclerViewIssues (List<IssuesResults> list) {

        adapterView = new IssuesRecyclerView(list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapterView);
    }

    private void getRecyclerViewVenom (List<IssuesResults> list) {

        venomAdapter = new VenomRecyclerView(list,this);
        recyclerViewVenom.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewVenom.setAdapter(venomAdapter);
    }

    private void getRecyclerViewIronMan (List<IssuesResults> list) {

        ironAdapter = new IronManRecyclerView(list,this);
        recyclerViewIron.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewIron.setAdapter(ironAdapter);
    }

    private void getRecyclerViewWolverine (List<IssuesResults> list) {

        ironAdapter = new IronManRecyclerView(list,this);
        recyclerViewWolverine.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewWolverine.setAdapter(ironAdapter);
    }
}
