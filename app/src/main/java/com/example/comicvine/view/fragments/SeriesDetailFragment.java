package com.example.comicvine.view.fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.comicvine.BuildConfig;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_episodes.EpisodesResult;
import com.example.comicvine.data.model.model_series_by_id.ResultSeriesById;
import com.example.comicvine.view.adapter.adapter_series.EpisodeAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesDetailFragment extends Fragment {

    private TextView title,year,episodes,description,go_to;
    private ImageView imageView;
    private ProgressBar progressBar;
    private LinearLayout linearLayout,layoutClick,layoutRecycler;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_detail, container, false);

        progressBar=view.findViewById(R.id.series_by_id_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        linearLayout=view.findViewById(R.id.series_by_id_id_layout);
        linearLayout.setVisibility(View.GONE);

        layoutClick=view.findViewById(R.id.layout_show_episodes);

        layoutRecycler=view.findViewById(R.id.episodes_recycler_layout);
        layoutRecycler.setVisibility(View.GONE);

        title=view.findViewById(R.id.series_by_id_title);
        year=view.findViewById(R.id.series_by_id_year);
        episodes=view.findViewById(R.id.series_by_id_number_of_episodes);
        description=view.findViewById(R.id.series_by_id_description);
        go_to=view.findViewById(R.id.series_by_id_go_to);
        imageView=view.findViewById(R.id.series_by_id_image);
        recyclerView=view.findViewById(R.id.episodes_recyclerView);

        if(getArguments()!=null) {

            String id = getArguments().getString("ID");

            VineViewModel viewModel = ViewModelProviders.of(this).get(VineViewModel.class);
            viewModel.getSeriesById(id);

            viewModel.getGetSeriesById().observe(this, new Observer<ResultSeriesById>() {
                @Override
                public void onChanged(ResultSeriesById resultSeriesById) {

                    progressBar.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);

                    Glide.with(Objects.requireNonNull(getContext()))
                            .load(resultSeriesById.getImage()
                                    .getMedium_url()).into(imageView);
                    title.setText(resultSeriesById.getName());
                    year.setText(resultSeriesById.getStart_year());
                    episodes.setText(String.valueOf(resultSeriesById.getCount_of_episodes()));

                    if(Build.VERSION.SDK_INT>=24) {
                        description.setText(Html.fromHtml(resultSeriesById.getDescription(), Html.FROM_HTML_MODE_LEGACY));
                    }else
                        description.setText(Html.fromHtml(resultSeriesById.getDescription()));

                }
            });
        }

        if (getArguments() != null) {

            String name = getArguments().getString("NAME");

            final VineViewModel viewModel = ViewModelProviders.of(SeriesDetailFragment.this).get(VineViewModel.class);
            viewModel.getEpisodesByName(name);

            layoutClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    viewModel.getGetEpisodesByName().observe(SeriesDetailFragment.this, new Observer<List<EpisodesResult>>() {
                        @Override
                        public void onChanged(List<EpisodesResult> episodesResults) {

                            layoutRecycler.setVisibility(View.VISIBLE);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            EpisodeAdapter adapter = new EpisodeAdapter(episodesResults, getContext());
                            recyclerView.setAdapter(adapter);

                            //TODO
                        }
                    });
                }

            });

        }

        return view;
    }

}
