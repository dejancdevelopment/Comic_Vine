package com.example.comicvine.view.fragments;


import android.content.Intent;
import android.net.Uri;
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
import com.example.comicvine.data.model.model_movie_by_id.MovieByIdResult;
import com.example.comicvine.view.viewmodel.IssuesViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieByIdFragment extends Fragment {

    TextView name,date,runtime,description,characters,link_movie;
    ImageView imageView;
    ProgressBar progressBar;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_movie_by_id, container, false);

        imageView=view.findViewById(R.id.movie_by_id_image);
        name=view.findViewById(R.id.movie_by_id_title);
        date=view.findViewById(R.id.movie_release_date);
        runtime=view.findViewById(R.id.movie_runtime);
        description=view.findViewById(R.id.movie_by_id_description);
        characters=view.findViewById(R.id.movie_characters);
        link_movie=view.findViewById(R.id.movie_by_id_link);
        progressBar=view.findViewById(R.id.movie_by_id_progress_bar);
        linearLayout=view.findViewById(R.id.movie_by_id_id_layout);

        progressBar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);

        if(getArguments()!=null) {

            String id = getArguments().getString("ID");

            IssuesViewModel viewModel = ViewModelProviders.of(this).get(IssuesViewModel.class);
            viewModel.getMovieById(id);

            viewModel.getGetMovieById().observe(this, new Observer<MovieByIdResult>() {
                @Override
                public void onChanged(final MovieByIdResult movieByIdResult) {

                    progressBar.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);

                    Glide.with(Objects.requireNonNull(getContext()))
                            .load(movieByIdResult.getImage()
                                    .getMedium_url()).into(imageView);

                    name.setText(movieByIdResult.getName());
                    date.setText(movieByIdResult.getRelease_date());
                    runtime.setText(movieByIdResult.getRuntime());
                    description.setText(movieByIdResult.getDescription());
                    characters.setText(movieByIdResult.getCharacters().get(0).getName());

                    link_movie.setText(movieByIdResult.getSite_detail_url());
                    link_movie.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Uri uri=Uri.parse(String.valueOf(movieByIdResult.getSite_detail_url()));
                            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                            startActivity(intent);
                        }
                    });

                }
            });


        }





        return view;
    }

}
