package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_episodes.EpisodesResult;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodeFragment extends Fragment {

    private TextView titile,number_of_,date,description,characters,link;
    private ImageView imageView;
    private ProgressBar progressBar;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_episode, container, false);

        imageView=view.findViewById(R.id.episode_image);
        titile=view.findViewById(R.id.episode_title);
        number_of_=view.findViewById(R.id.episode_number_of_episode);
        date=view.findViewById(R.id.episodes_air_date);
        description=view.findViewById(R.id.episode_description);
        characters=view.findViewById(R.id.episode_characters);
        link=view.findViewById(R.id.episode_link);
        linearLayout=view.findViewById(R.id.episode_layout);
        progressBar=view.findViewById(R.id.episodes_progress_bar);

        progressBar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);

        if(getArguments()!=null){

            String id=getArguments().getString("ID");

            IssuesViewModel viewModel= ViewModelProviders.of(this).get(IssuesViewModel.class);
            viewModel.getEpisodesById(id);

            viewModel.getGetEpisodesById().observe(this, new Observer<EpisodesResult>() {
                @Override
                public void onChanged(EpisodesResult episodesResult) {
                    progressBar.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);

                    Glide.with(Objects.requireNonNull(getContext()))
                            .load(episodesResult.getImage()
                                    .getMedium_url()).into(imageView);
                    titile.setText(episodesResult.getName());
                    number_of_.setText(episodesResult.getEpisode_number());
                    date.setText(episodesResult.getAir_date());

                    link.setText(episodesResult.getSite_detail_url());



                }
            });

        }
        return view;
    }
}
