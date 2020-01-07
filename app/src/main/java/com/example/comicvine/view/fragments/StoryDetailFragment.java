package com.example.comicvine.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryDetailFragment extends Fragment {

    private TextView title,description;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_story_detail, container, false);

        title=view.findViewById(R.id.story_by_id_name);
        description=view.findViewById(R.id.story_by_id_description);
        imageView=view.findViewById(R.id.stories_by_id_image_);

        if(getArguments()!=null){

            String id=getArguments().getString("ID");

            VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
            viewModel.getStoryById(id);

            viewModel.getGetStorieById().observe(this, new Observer<ResultsStoryById>() {
                @Override
                public void onChanged(ResultsStoryById resultsStoryById) {

                    Glide.with(Objects.requireNonNull(getContext())).load(resultsStoryById
                            .getImage().getMedium_url())
                            .into(imageView);
                    title.setText(resultsStoryById.getName());
                    description.setText(Html.fromHtml(resultsStoryById.
                            getDescription(),Html.FROM_HTML_MODE_LEGACY));

                    Linkify.addLinks(description, Linkify.WEB_URLS);//TODO

                }
            });

        }

        return view;
    }

}
