package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicvine.data.model_by_id.CharacterCredits;
import com.example.comicvine.data.model_by_id.LocationCredits;
import com.example.comicvine.data.model_by_id.PersonalCredits;
import com.example.comicvine.data.model_by_id.ResultsById;
import com.example.comicvine.data.model_by_id.TeamCredits;
import com.example.comicvine.view.adapter.CharactersByIdRecyclerView;
import com.example.comicvine.view.adapter.CreatorsByIdRecyclerView;
import com.example.comicvine.view.adapter.LocationByIdRecyclerView;
import com.example.comicvine.view.adapter.TeamByIdRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    IssuesViewModel viewModel;

    private ImageView imageView;
    private TextView description;
    private TextView title;
    private TextView issue_num;
    private RecyclerView creatorsRec;
    private RecyclerView charactersRec;
    private RecyclerView teamsRec;
    private RecyclerView locationsRec;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        layout = findViewById(R.id.detail_layout);

        imageView = findViewById(R.id.id_image);
        title = findViewById(R.id.id_title);
        issue_num = findViewById(R.id.id_issue_number);
        description = findViewById(R.id.id_description);
        creatorsRec = findViewById(R.id.id_creators_recycler);
        charactersRec = findViewById(R.id.id_characters_recycler);
        teamsRec = findViewById(R.id.id_teams_recycler);
        locationsRec = findViewById(R.id.id_locations_recycler);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("ID");

        viewModel = ViewModelProviders.of(this).get(IssuesViewModel.class);
        viewModel.getIssueById(id);
        Log.d("QQQ", "onResponse: " + "activity");

        layout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                layout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

                viewModel.getByIdLiveData().observe(DetailActivity.this, new Observer<ResultsById>() {
                    @Override
                    public void onChanged(ResultsById resultsById) {

                        getSupportActionBar().setTitle(resultsById.getVolume().getName());

                        Glide.with(Objects.requireNonNull(DetailActivity.this))
                                .load(resultsById.getImage().getSmall_url())
                                .into(imageView);
                        title.setText(resultsById.getVolume().getName());
                        issue_num.setText(resultsById.getIssue_number());
                        description.setText(resultsById.getDescription());

                        getCreatorList(resultsById.getPerson_credits());
                        getCharactersList(resultsById.getCharacter_credits());
                        getTeamList(resultsById.getTeam_credits());
                        getLocationList(resultsById.getLocation_credits());
                    }
                });

            }
        },2000);
    }

    private void getCreatorList(ArrayList<PersonalCredits> list) {

        CreatorsByIdRecyclerView adapter = new CreatorsByIdRecyclerView(list, this);
        creatorsRec.setLayoutManager(new LinearLayoutManager(this));
        creatorsRec.setAdapter(adapter);
    }

    private void getCharactersList(ArrayList<CharacterCredits> list) {

        CharactersByIdRecyclerView adapter = new CharactersByIdRecyclerView(list, this);
        charactersRec.setLayoutManager(new LinearLayoutManager(this));
        charactersRec.setAdapter(adapter);
    }

    private void getTeamList(ArrayList<TeamCredits> list) {

        TeamByIdRecyclerView adapter = new TeamByIdRecyclerView(list, this);
        teamsRec.setLayoutManager(new LinearLayoutManager(this));
        teamsRec.setAdapter(adapter);
    }

    private void getLocationList(ArrayList<LocationCredits> list) {

        LocationByIdRecyclerView adapter = new LocationByIdRecyclerView(list, this);
        locationsRec.setLayoutManager(new LinearLayoutManager(this));
        locationsRec.setAdapter(adapter);
    }
}
