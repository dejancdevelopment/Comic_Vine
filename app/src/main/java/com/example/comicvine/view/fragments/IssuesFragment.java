package com.example.comicvine.view.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicvine.AllIssuesActivity;
import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.AvengersManRecyclerView;
import com.example.comicvine.view.adapter.CaptainMarvelManRecyclerView;
import com.example.comicvine.view.adapter.IronManRecyclerView;
import com.example.comicvine.view.adapter.IssuesRecyclerView;
import com.example.comicvine.view.adapter.PromosRecyclerView;
import com.example.comicvine.view.adapter.VenomRecyclerView;
import com.example.comicvine.view.adapter.WolverineManRecyclerView;
import com.example.comicvine.view.animation.ZoomCenterCardLayoutManager;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

public class IssuesFragment extends Fragment {

    private RecyclerView recyclerView,
            recyclerViewVenom,
            recyclerViewIron,
            recyclerViewWolverine ,
            recyclerCaptainMarvel,
            recyclerAvengers,
            recyclerPromos;

    private TextView seeallIssues,
            seeAllVenom,
            seeAllIronMan,
            seeAllWolverine,
            seeAllCaptainMarvel,
            seeAllAvengers;


    private IssuesRecyclerView adapterView;
    private VenomRecyclerView venomAdapter;
    private IronManRecyclerView ironAdapter;
    private WolverineManRecyclerView wolverineAdapter;
    private CaptainMarvelManRecyclerView captainMarvelAdapter;
    private AvengersManRecyclerView avengersAdapter;

    ProgressBar progressBar;
    LinearLayout linearLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_issues,container,false);
        progressBar=view.findViewById(R.id.progress_bar_issues);
        progressBar.setVisibility(View.VISIBLE);
        linearLayout=view.findViewById(R.id.layout_issues);
        linearLayout.setVisibility(View.GONE);

        recyclerView =view.findViewById(R.id.recycler_view_issues);
        recyclerViewVenom=view.findViewById(R.id.recycler_view_venom);
        recyclerViewIron=view.findViewById(R.id.recycler_view_iron_man);
        recyclerViewWolverine=view.findViewById(R.id.recycler_view_wolverine);
        recyclerCaptainMarvel=view.findViewById(R.id.recycler_view_captain_marvel);
        recyclerAvengers=view.findViewById(R.id.recycler_view_avengers);

        seeallIssues =view.findViewById(R.id.see_all_issues);
        seeAllVenom=view.findViewById(R.id.see_all_venom);
        seeAllIronMan=view.findViewById(R.id.see_all_iron_man);
        seeAllWolverine=view.findViewById(R.id.see_all_wolverine);
        seeAllCaptainMarvel=view.findViewById(R.id.see_all_captain_marvel);
        seeAllAvengers=view.findViewById(R.id.see_all_avengers);

        seeallIssues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"allIssues");
            }
        });
        seeAllVenom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"venom");
            }
        });
        seeAllIronMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"ironMan");
            }
        });
        seeAllWolverine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"wolverine");
            }
        });
        seeAllCaptainMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"captainMarvel");
            }
        });
        seeAllAvengers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAll(new AllIssuesActivity(),"avengers");
            }
        });


        VineViewModel viewModel = ViewModelProviders
                .of(this)
                .get(VineViewModel.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);

            }
        },2000);

        viewModel.getGetAllIssues().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewIssues(issuesResults);

            }
        });

        viewModel.getGetAllVenom().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewVenom(issuesResults);
            }
        });

        viewModel.getGetAllIronMan().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewIronMan(issuesResults);
            }
        });

        viewModel.getGetAllWolverine().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewWolverine(issuesResults);
            }
        });

        viewModel.getGetAllCaptainMarvel().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewCaptainMarvel(issuesResults);
            }
        });

        viewModel.getGetAllAvengers().observe(this, new Observer<List<IssuesResults>>() {
            @Override
            public void onChanged(List<IssuesResults> issuesResults) {

                getRecyclerViewAvengers(issuesResults);
            }
        });

        return view;
    }

    private void seeAll(Activity activity, String value){

        Intent intent=new Intent(getContext(),activity.getClass());
        intent.putExtra("ALL",value);
        startActivity(intent);
    }
    private void getRecyclerViewIssues (List<IssuesResults> list) {
        adapterView = new IssuesRecyclerView(list,getContext());
        recyclerView.setLayoutManager(new ZoomCenterCardLayoutManager
                (getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapterView);
    }
    private void getRecyclerViewVenom (List<IssuesResults> list) {
        venomAdapter = new VenomRecyclerView(list,getContext());
        recyclerViewVenom.setLayoutManager
                (new ZoomCenterCardLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewVenom.setAdapter(venomAdapter);
    }
    private void getRecyclerViewIronMan (List<IssuesResults> list) {
        ironAdapter = new IronManRecyclerView(list,getContext());
        recyclerViewIron.setLayoutManager
                (new ZoomCenterCardLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewIron.setAdapter(ironAdapter);
    }
    private void getRecyclerViewWolverine (List<IssuesResults> list) {
        wolverineAdapter = new WolverineManRecyclerView (list,getContext());
        recyclerViewWolverine.setLayoutManager
                (new ZoomCenterCardLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewWolverine.setAdapter(wolverineAdapter);
    }
    private void getRecyclerViewCaptainMarvel (List<IssuesResults> list) {
        captainMarvelAdapter = new CaptainMarvelManRecyclerView (list,getContext());
        recyclerCaptainMarvel.setLayoutManager
                (new ZoomCenterCardLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerCaptainMarvel.setAdapter(captainMarvelAdapter);
    }
    private void getRecyclerViewAvengers (List<IssuesResults> list) {
        avengersAdapter = new AvengersManRecyclerView (list,getContext());
        recyclerAvengers.setLayoutManager
                (new ZoomCenterCardLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerAvengers.setAdapter(avengersAdapter);
    }
}
