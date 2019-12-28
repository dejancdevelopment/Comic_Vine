package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.AvengersManRecyclerView;
import com.example.comicvine.view.adapter.CaptainMarvelManRecyclerView;
import com.example.comicvine.view.adapter.IronManRecyclerView;
import com.example.comicvine.view.adapter.IssuesRecyclerView;
import com.example.comicvine.view.adapter.PromosRecyclerView;
import com.example.comicvine.view.adapter.VenomRecyclerView;
import com.example.comicvine.view.adapter.WolverineManRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.Collections;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {

    RecyclerView recyclerView,
            recyclerViewVenom,
            recyclerViewIron,
            recyclerViewWolverine ,
            recyclerCaptainMarvel,
            recyclerAvengers,
            recyclerPromos;

    TextView seeall;

    IssuesRecyclerView adapterView;
    VenomRecyclerView venomAdapter;
    IronManRecyclerView ironAdapter;
    WolverineManRecyclerView wolverineAdapter;
    CaptainMarvelManRecyclerView captainMarvelAdapter;
    AvengersManRecyclerView avengersAdapter;
    PromosRecyclerView promosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_issues);
        recyclerViewVenom=findViewById(R.id.recycler_view_venom);
        recyclerViewIron=findViewById(R.id.recycler_view_iron_man);
        recyclerViewWolverine=findViewById(R.id.recycler_view_wolverine);
        recyclerCaptainMarvel=findViewById(R.id.recycler_view_captain_marvel);
        recyclerAvengers=findViewById(R.id.recycler_view_avengers);
        recyclerPromos=findViewById(R.id.recycler_view_promos);
        seeall=findViewById(R.id.see_all_issues);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    seeAll(new DetailActivity(),"allIssues");
//                Toast.makeText(MainPageActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });

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

                Collections.reverse(issuesResults);  ///TODO plus ne mi gi dava slikite od DAO
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

        viewModel.getGetCaptainMarvel().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewCaptainMarvel(issuesResults);
            }
        });

        viewModel.getGetAvengers().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewAvengers(issuesResults);
            }
        });

        viewModel.getGetPromos().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewPromos(issuesResults);
            }
        });

    }
////

    private void seeAll(Activity activity, String value){

        Intent intent=new Intent(MainPageActivity.this,activity.getClass());
        intent.putExtra("ISSUES",value);
        startActivity(intent);

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

        wolverineAdapter = new WolverineManRecyclerView (list,this);
        recyclerViewWolverine.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewWolverine.setAdapter(wolverineAdapter);
    }

    private void getRecyclerViewCaptainMarvel (List<IssuesResults> list) {

        captainMarvelAdapter = new CaptainMarvelManRecyclerView (list,this);
        recyclerCaptainMarvel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerCaptainMarvel.setAdapter(captainMarvelAdapter);
    }


    private void getRecyclerViewAvengers (List<IssuesResults> list) {

        avengersAdapter = new AvengersManRecyclerView (list,this);
        recyclerAvengers.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerAvengers.setAdapter(avengersAdapter);
    }

    private void getRecyclerViewPromos (List<IssuesResults> list) {

        promosAdapter = new PromosRecyclerView (list,this);
        recyclerPromos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerPromos.setAdapter(promosAdapter);
    }
}