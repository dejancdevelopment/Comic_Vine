package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_episodes.EpisodesResult;
import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.model.model_by_id.ResultsById;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_movie_by_id.MovieByIdResult;
import com.example.comicvine.data.model.model_movies.ResultByMovies;
import com.example.comicvine.data.model.model_series.ResultBySeries;
import com.example.comicvine.data.model.model_series_by_id.ResultSeriesById;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;
import com.example.comicvine.data.repository.CharactersRepo;
import com.example.comicvine.data.repository.IssuesRepo;
import com.example.comicvine.data.repository.MoviesRepo;
import com.example.comicvine.data.repository.SeriesRepo;
import com.example.comicvine.data.repository.StoriesRepo;

import java.util.List;

public class IssuesViewModel extends AndroidViewModel {

    private IssuesRepo issuesRepo;
    private CharactersRepo charactersRepo;
    private StoriesRepo storiesRepo;
    private SeriesRepo seriesRepo;
    private MoviesRepo moviesRepo;

    public IssuesViewModel(@NonNull Application application) {
        super(application);

        issuesRepo=IssuesRepo.getInstance(application);
        charactersRepo=CharactersRepo.getInstance(application);
        storiesRepo=StoriesRepo.getInstance(application);
        seriesRepo=SeriesRepo.getInstance(application);
        moviesRepo=MoviesRepo.getInstance(application);
    }

    public LiveData<ResultsById> getGetIssuesById(String id) {
        return issuesRepo.getIssuesById(id);
    }

    public LiveData<List<IssuesResults>> getAllIssues() {
        return issuesRepo.getAllIssues();
    }

    public LiveData<List<IssuesResults>> getGetAllVenom() {
        return issuesRepo.getAllVenom();
    }

    public LiveData<List<IssuesResults>> getGetAllIronMan() {
        return issuesRepo.getAllIronMan();
    }

    public LiveData<List<IssuesResults>> getGetAllWolverine() {
        return issuesRepo.getAllWolverine();
    }
    public LiveData<List<IssuesResults>> getGetAllCaptainMarvel() {
        return issuesRepo.getAllCaptainMarvel();
    }
    public LiveData<List<IssuesResults>> getGetAllAvengers() {
        return issuesRepo.getAllAvengers();
    }

    public LiveData<List<ResultsByCharacters>> getGetAllCharacters() {
        return charactersRepo.getAllCharacters();
    }

    public LiveData<List<ResultsByCharacters>> getGetAllStories() {
        return storiesRepo.getAllStories();
    }

    public LiveData<List<ResultBySeries>> getGetAllSeries() {
        return seriesRepo.getAllSeries();
    }

    public LiveData<List<ResultByMovies>> getGetAllMovies() {
        return moviesRepo.getAllMovies();
    }

    public LiveData<List<ResultsByCharacters>> getGetCharacterByName(String name) {
        return charactersRepo.getCharacterByName(name);
    }

    public LiveData<List<IssuesResults>> getGetIssuesByName(String name) {
        return charactersRepo.getCharacterIssuesBy(name);
    }

    public LiveData<ResultsStoryById> getGetStorieById(String id) {
        return storiesRepo.getStoryiesById(id);
    }

    public LiveData<ResultSeriesById> getGetSeriesById(String id) {
        return seriesRepo.getSetSeriesById(id);
    }

    public LiveData<EpisodesResult> getGetEpisodesById(String id) {
        return seriesRepo.getEpisodesById(id);
    }

    public LiveData<MovieByIdResult> getGetMovieById(String id) {
        return moviesRepo.getMovieById(id);
    }
}
