package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_by_id.CharacterCredits;
import com.example.comicvine.data.model.model_by_id.LocationCredits;
import com.example.comicvine.data.model.model_by_id.PersonalCredits;
import com.example.comicvine.data.model.model_by_id.ResultsById;
import com.example.comicvine.data.model.model_by_id.TeamCredits;
import com.example.comicvine.view.adapter.adapter_issues.CharactersByIdRecyclerView;
import com.example.comicvine.view.adapter.adapter_issues.CreatorsByIdRecyclerView;
import com.example.comicvine.view.adapter.adapter_issues.LocationByIdRecyclerView;
import com.example.comicvine.view.adapter.adapter_issues.TeamByIdRecyclerView;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class IssuesDetailFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_issues_detail, container, false);

        Toolbar toolbar =view.findViewById(R.id.toolbar_detail);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity)
                Objects.requireNonNull(getActivity()))
                .getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final ProgressBar progressBar =view.findViewById(R.id.progress_bar);
        layout = view.findViewById(R.id.detail_layout);

        imageView = view.findViewById(R.id.id_image);
        title = view.findViewById(R.id.id_title);
        issue_num = view.findViewById(R.id.id_issue_number);
        description = view.findViewById(R.id.id_description);
        creatorsRec = view.findViewById(R.id.id_creators_recycler);
        charactersRec = view.findViewById(R.id.id_characters_recycler);
        teamsRec = view.findViewById(R.id.id_teams_recycler);
        locationsRec = view.findViewById(R.id.id_locations_recycler);

        layout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        if(getArguments()!=null) {

            String id = getArguments().getString("ID");

            viewModel = ViewModelProviders.of(this).get(IssuesViewModel.class);
            viewModel.getIssueById(id);
            Log.d("QQQ", "onResponse: " + "activity");


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    layout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);

                    viewModel.getGetIssuesById().observe(IssuesDetailFragment.this, new Observer<ResultsById>() {
                        @Override
                        public void onChanged(ResultsById resultsById) {

                            ((AppCompatActivity) Objects.requireNonNull(getActivity()))
                                    .setTitle(resultsById.getVolume().getName());

                            Glide.with(IssuesDetailFragment.this)
                                    .load(resultsById.getImage().getSmall_url())
                                    .into(imageView);
                            title.setText(resultsById.getVolume().getName());
                            issue_num.setText(resultsById.getIssue_number());
                            description.setText(Html.fromHtml(resultsById.getDescription(),Html.FROM_HTML_MODE_LEGACY));

                            getCreatorList(resultsById.getPerson_credits());
                            getCharactersList(resultsById.getCharacter_credits());
                            getTeamList(resultsById.getTeam_credits());
                            getLocationList(resultsById.getLocation_credits());
                        }
                    });

                }
            },1500);

        }

        return view;
    }

    private void getCreatorList(ArrayList<PersonalCredits> list) {

        CreatorsByIdRecyclerView adapter = new CreatorsByIdRecyclerView(list, getContext());
        creatorsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        creatorsRec.setAdapter(adapter);
    }

    private void getCharactersList(ArrayList<CharacterCredits> list) {

        CharactersByIdRecyclerView adapter = new CharactersByIdRecyclerView(list, getContext());
        charactersRec.setLayoutManager(new LinearLayoutManager(getContext()));
        charactersRec.setAdapter(adapter);
    }

    private void getTeamList(ArrayList<TeamCredits> list) {

        TeamByIdRecyclerView adapter = new TeamByIdRecyclerView(list, getContext());
        teamsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        teamsRec.setAdapter(adapter);
    }

    private void getLocationList(ArrayList<LocationCredits> list) {

        LocationByIdRecyclerView adapter = new LocationByIdRecyclerView(list, getContext());
        locationsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        locationsRec.setAdapter(adapter);
    }

}
