package com.example.comicvine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.view.adapter.IssuesAllLinearAdapter;
import com.example.comicvine.view.adapter.IssuesAllRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.List;
import java.util.Objects;

public class AllIssuesActivity extends AppCompatActivity {

    private RecyclerView allIssuesRecycler;
    IssuesAllLinearAdapter allLinearAdapter;
    private IssuesAllRecyclerView adapterIssues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_issues);

        Toolbar toolbar = findViewById(R.id.toolbar_all_issues);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        final ProgressBar progressBar = findViewById(R.id.progress_bar_all);

        allIssuesRecycler = findViewById(R.id.all_issues_recycler);
        allIssuesRecycler.setLayoutManager(new GridLayoutManager(this, 3));

       final IssuesViewModel viewModel = ViewModelProviders.of(this).get(IssuesViewModel.class);

       progressBar.setVisibility(View.VISIBLE);
       allIssuesRecycler.setVisibility(View.GONE);

        Intent intent = getIntent();
        final String allIssues = intent.getStringExtra("ALL");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                allIssuesRecycler.setVisibility(View.VISIBLE);

                if (allIssues != null) {
                    if (allIssues.contains("allIssues")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Featured");

                        viewModel.getGetAllIssues()
                                .observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {

                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    } else if (allIssues.contains("venom")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Venom Collection");

                        viewModel.getGetAllVenom().observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {

                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    } else if (allIssues.contains("ironMan")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Iron Man Collection");

                        viewModel.getGetAllIronMan()
                                .observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {

                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    } else if (allIssues.contains("wolverine")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Wolverine Collection");

                        viewModel.getGetAllWolverine()
                                .observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {

                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    } else if (allIssues.contains("captainMarvel")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Captain Marvel Collection");

                        viewModel.getGetAllCaptainMarvel()
                                .observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {

                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    } else if (allIssues.contains("avengers")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle("Avengers Collection");

                        viewModel.getGetAllAvengers()
                                .observe(AllIssuesActivity.this, new Observer<List<IssuesResults>>() {
                            @Override
                            public void onChanged(List<IssuesResults> issuesResults) {
                                adapterIssues = new IssuesAllRecyclerView(issuesResults, AllIssuesActivity.this);
                                allLinearAdapter=new IssuesAllLinearAdapter(issuesResults,AllIssuesActivity.this);
                                allIssuesRecycler.setAdapter(adapterIssues);
                            }
                        });
                    }
                }

            }
        }, 1500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.search_menu_btn:
                SearchView searchView= (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        adapterIssues.getFilter().filter(newText);
                        allLinearAdapter.getFilter().filter(newText);

                        return false;
                    }
                });
                break;
            case R.id.oreder_in_linear:
                allIssuesRecycler.setLayoutManager(new LinearLayoutManager(this));
                allIssuesRecycler.setAdapter(allLinearAdapter);
                break;

                default:
        }
        return super.onOptionsItemSelected(item);
    }
}
