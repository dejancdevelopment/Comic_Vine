package com.example.comicvine.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
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

public class DetailFragment extends Fragment {

    private ImageView imageView;
    private TextView description;
    private TextView title;
    private TextView issue_num;
    private RecyclerView creatorsRec;
    private RecyclerView charactersRec;
    private RecyclerView teamsRec;
    private RecyclerView locationsRec;
    private String id;

    public DetailFragment(String id) {
        this.id=id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_detail,container,false);


        imageView=view.findViewById(R.id.id_image);
        title=view.findViewById(R.id.id_title);
        issue_num=view.findViewById(R.id.id_issue_number);
        description=view.findViewById(R.id.id_description);
        creatorsRec=view.findViewById(R.id.id_creators_recycler);
        charactersRec=view.findViewById(R.id.id_characters_recycler);
        teamsRec=view.findViewById(R.id.id_teams_recycler);
        locationsRec=view.findViewById(R.id.id_locations_recycler);

        IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);

        viewModel.getIssueById(id);

        viewModel.getByIdLiveData().observe(this, new Observer<ResultsById>() {
            @Override
            public void onChanged(ResultsById resultsById) {

                Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar())
                        .setTitle(resultsById.getVolume().getName());
                Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar())
                        .setDisplayHomeAsUpEnabled(true);

                Glide.with(Objects.requireNonNull(getContext()))
                        .load(resultsById.getImage().getScreen_large_url())
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

        return view;
    }

    private void getCreatorList (ArrayList<PersonalCredits> list){

        CreatorsByIdRecyclerView adapter=new CreatorsByIdRecyclerView(list,getContext());
        creatorsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        creatorsRec.setAdapter(adapter);

    }

    private void getCharactersList (ArrayList<CharacterCredits> list){

        CharactersByIdRecyclerView adapter=new CharactersByIdRecyclerView(list,getContext());
        charactersRec.setLayoutManager(new LinearLayoutManager(getContext()));
        charactersRec.setAdapter(adapter);

    }

    private void getTeamList (ArrayList<TeamCredits> list){

        TeamByIdRecyclerView adapter=new TeamByIdRecyclerView(list,getContext());
        teamsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        teamsRec.setAdapter(adapter);

    }

    private void getLocationList (ArrayList<LocationCredits> list){

        LocationByIdRecyclerView adapter=new LocationByIdRecyclerView(list,getContext());
        locationsRec.setLayoutManager(new LinearLayoutManager(getContext()));
        locationsRec.setAdapter(adapter);

    }
}
