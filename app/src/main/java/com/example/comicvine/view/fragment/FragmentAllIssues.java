package com.example.comicvine.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.comicvine.R;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.AvengersManRecyclerView;
import com.example.comicvine.view.adapter.CaptainMarvelManRecyclerView;
import com.example.comicvine.view.adapter.IronManRecyclerView;
import com.example.comicvine.view.adapter.IssuesRecyclerView;
import com.example.comicvine.view.adapter.VenomRecyclerView;
import com.example.comicvine.view.adapter.WolverineManRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAllIssues extends Fragment {

    private RecyclerView allIssuesRecycler;
    private IssuesRecyclerView adapterIssues;
    private VenomRecyclerView adapterVenom;
    private IronManRecyclerView adapterIronMan;
    private WolverineManRecyclerView adapterWolverine;
    private CaptainMarvelManRecyclerView adapterCataptainMarvel;
    private AvengersManRecyclerView adapterAvengers;

    String allIssues;

    public FragmentAllIssues() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_all_issues, container, false);

        Toolbar toolbar=view.findViewById(R.id.toolbar_all_issues);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        allIssuesRecycler=view.findViewById(R.id.all_issues_recycler);
        allIssuesRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));

        IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);

        if(getArguments()!=null){

            allIssues=getArguments().getString("ALL");

            if(allIssues.contains("allIssues")){

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Featured");

                viewModel.getGetAllIssues().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("allVenom")){

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Venom Collection");

                viewModel.getGetAllVenom().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterVenom=new VenomRecyclerView(issuesResults,getContext());//TODO
                        allIssuesRecycler.setAdapter(adapterVenom);
                    }
                });
            }else if (allIssues.contains("allIronMan")) {

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Iron Man Collection");
                viewModel.getGetAllIronMan().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIronMan=new IronManRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterIronMan);
                    }
                });
            }else if (allIssues.contains("allWolverine")) {

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Wolverine Collection");

                viewModel.getGetAllWolverine().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterWolverine=new WolverineManRecyclerView(issuesResults, getContext());
                        allIssuesRecycler.setAdapter(adapterWolverine);
                    }
                });
            }else if (allIssues.contains("allCaptainMarvel")) {

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Captain Marvel Collection");

                viewModel.getGetCaptainMarvel().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterCataptainMarvel=new CaptainMarvelManRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterCataptainMarvel);
                    }
                });
            }else if (allIssues.contains("allAvengers")) {

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle("Avengers Collection");

                viewModel.getGetAllAvengers().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterAvengers=new AvengersManRecyclerView(issuesResults,getContext());
                        allIssuesRecycler.setAdapter(adapterAvengers);
                    }
                });
            }
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search_layout,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.search_menu_btn:
                Toast.makeText(getContext(), "search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.oreder_in_linear:
                if(allIssues.contains("allIssues")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterIssues);
                }else if(allIssues.contains("allVenom")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterVenom);
                }else if(allIssues.contains("allIronMan")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterIronMan);
                }else if(allIssues.contains("allWolverine")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterWolverine);
                }else if(allIssues.contains("allCaptainMarvel")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterCataptainMarvel);
                }else if(allIssues.contains("allAvengers")){
                    allIssuesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    allIssuesRecycler.setAdapter(adapterAvengers);
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
