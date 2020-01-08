package com.example.comicvine.view.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.comicvine.R;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;
import com.example.comicvine.view.adapter.adapter_stories.StoriesToIssuesAdapter;
import com.example.comicvine.view.viewmodel.VineViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryDetailFragment extends Fragment {

    private TextView title,description;
    private ImageView imageView;
    private RecyclerView relatedIsssuesRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_story_detail, container, false);

        final ProgressBar progressBar = view.findViewById(R.id.progress_bar_story_detail);
        final LinearLayout layout = view.findViewById(R.id.story_detail_layout);
        layout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);


        title=view.findViewById(R.id.story_by_id_name);
        description=view.findViewById(R.id.story_by_id_description);
        description.setMovementMethod(LinkMovementMethod.getInstance());//TODO

        imageView=view.findViewById(R.id.stories_by_id_image_);
        relatedIsssuesRecycler=view.findViewById(R.id.recycler_view_story_issues);
        relatedIsssuesRecycler.setLayoutManager
                (new LinearLayoutManager(getContext()));

        if(getArguments()!=null){

            String id=getArguments().getString("ID");

            VineViewModel viewModel= ViewModelProviders.of(this).get(VineViewModel.class);
            viewModel.getStoryById(id);

            viewModel.getGetStorieById().observe(this, new Observer<ResultsStoryById>() {
                @Override
                public void onChanged(ResultsStoryById resultsStoryById) {


                    layout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);

                    Glide.with(Objects.requireNonNull(getContext())).load(resultsStoryById
                            .getImage().getMedium_url())
                            .into(imageView);
                    title.setText(resultsStoryById.getName());

                    if (Build.VERSION.SDK_INT >= 24) {
                        description.setText(Html.fromHtml(resultsStoryById.
                                getDescription(),Html.FROM_HTML_MODE_LEGACY));
//                        description.setMovementMethod(LinkMovementMethod.getInstance());

                    } else {
                        description.setText(Html.fromHtml(resultsStoryById.
                                getDescription()));
//                        description.setMovementMethod(LinkMovementMethod.getInstance());
                    }

                    StoriesToIssuesAdapter adapter=new StoriesToIssuesAdapter(
                            resultsStoryById.getIssues(),getContext());
                    relatedIsssuesRecycler.setAdapter(adapter);
                }
            });
        }

        return view;
    }

}
