package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        final ProgressBar progressBar=view.findViewById(R.id.progress_picture);
        final ImageView imageView=view.findViewById(R.id.picture_view);

        progressBar.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);


        if (getArguments() != null) {

            String name = getArguments().getString("NAME_");

            VineViewModel viewModel = ViewModelProviders.of(this).get(VineViewModel.class);

            viewModel.getCharacterbyName(name);
            viewModel.getGetCharacterByName().observe(this, new Observer<List<ResultsByCharacters>>() {
                @Override
                public void onChanged(List<ResultsByCharacters> resultsByCharacters) {

                    Glide.with(getContext()).load(resultsByCharacters.get(0).getImage().getScreen_large_url())
                            .into(imageView);

                    progressBar.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);

                }
            });
        }

        return view;
    }
}
