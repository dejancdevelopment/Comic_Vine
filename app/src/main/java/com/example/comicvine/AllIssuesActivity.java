package com.example.comicvine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.IssuesAllRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.List;
import java.util.Objects;

public class AllIssuesActivity extends AppCompatActivity {

    private RecyclerView allIssuesRecycler;
    private IssuesAllRecyclerView adapterIssues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_issues);

        Toolbar toolbar=findViewById(R.id.toolbar_all_issues);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ProgressBar progressBar=findViewById(R.id.progress_bar);

        allIssuesRecycler=findViewById(R.id.all_issues_recycler);
        allIssuesRecycler.setLayoutManager(new GridLayoutManager(this,3));

        IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);

        Intent intent=getIntent();
            String allIssues = intent.getStringExtra("ALL");

        if (allIssues != null) {
            if(allIssues.contains("allIssues")){
                getSupportActionBar().setTitle("Featured");

                viewModel.getGetAllIssues().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("venom")){
                getSupportActionBar().setTitle("Venom Collection");

                viewModel.getGetAllVenom().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("ironMan")) {
                getSupportActionBar().setTitle("Iron Man Collection");

                viewModel.getGetAllIronMan().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("wolverine")) {
                getSupportActionBar().setTitle("Wolverine Collection");

                viewModel.getGetAllWolverine().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("captainMarvel")) {
                getSupportActionBar().setTitle("Captain Marvel Collection");

                viewModel.getGetAllCaptainMarvel().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {

                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }else if (allIssues.contains("avengers")) {
                getSupportActionBar().setTitle("Avengers Collection");

                viewModel.getGetAllAvengers().observe(this, new Observer<List<IssuesResults>>() {
                    @Override
                    public void onChanged(List<IssuesResults> issuesResults) {
                        adapterIssues =new IssuesAllRecyclerView(issuesResults,AllIssuesActivity.this);
                        allIssuesRecycler.setAdapter(adapterIssues);
                    }
                });
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.search_menu_btn:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.oreder_in_linear:
                allIssuesRecycler.setLayoutManager(new LinearLayoutManager(this));
                allIssuesRecycler.setAdapter(adapterIssues);
        }
        return super.onOptionsItemSelected(item);
    }
}
