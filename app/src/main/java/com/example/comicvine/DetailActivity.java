package com.example.comicvine;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.example.comicvine.view.fragments.CharactersDetailFragment;
import com.example.comicvine.view.fragments.EpisodeFragment;
import com.example.comicvine.view.fragments.IssuesDetailFragment;
import com.example.comicvine.view.fragments.MovieByIdFragment;
import com.example.comicvine.view.fragments.SeriesDetailFragment;
import com.example.comicvine.view.fragments.StoryDetailFragment;


public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String by=intent.getStringExtra("BY");

        if (by.contains("id")) {

           String id = intent.getStringExtra("ID");

            IssuesDetailFragment issuesDetailFragment = new IssuesDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ID", id);
            issuesDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, issuesDetailFragment)
                    .commit();
        }else if(by.contains("name")){

            String name=intent.getStringExtra("NAME");

            CharactersDetailFragment charactersDetailFragment=new CharactersDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("NAME",name);
            charactersDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, charactersDetailFragment)
                    .commit();
        }else if(by.contains("story")){

            String idStory=intent.getStringExtra("ID");

            StoryDetailFragment storyDetailFragment=new StoryDetailFragment();
            Bundle bundle=new Bundle();
            bundle.putString("ID",idStory);
            storyDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, storyDetailFragment)
                    .commit();
        }else if(by.contains("series")){

            String idSeries=intent.getStringExtra("ID");
            String nameSeries=intent.getStringExtra("NAME");

            SeriesDetailFragment seriesDetailFragment=new SeriesDetailFragment();
            Bundle bundle=new Bundle();
            bundle.putString("ID",idSeries);
            bundle.putString("NAME",nameSeries);
            seriesDetailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, seriesDetailFragment)
                    .commit();
        }else if(by.contains("episode")){

            String idEpisode=intent.getStringExtra("ID");

            EpisodeFragment episodeFragment=new EpisodeFragment();
            Bundle bundle=new Bundle();
            bundle.putString("ID",idEpisode);
            episodeFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, episodeFragment)
                    .commit();
        }else if(by.contains("movie")){

            String idMovie=intent.getStringExtra("ID");

            MovieByIdFragment movieByIdFragment=new MovieByIdFragment();
            Bundle bundle=new Bundle();
            bundle.putString("ID",idMovie);
            movieByIdFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, movieByIdFragment)
                    .commit();
        }
    }
}
