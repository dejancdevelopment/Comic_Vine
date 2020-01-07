package com.example.comicvine.view.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.model.model_by_id.ResultsById;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_movies.ResultByMovies;
import com.example.comicvine.data.model.model_series.ResultBySeries;
import com.example.comicvine.data.repository.CharactersRepo;
import com.example.comicvine.data.repository.IssuesRepo;
import com.example.comicvine.data.repository.MoviesRepo;
import com.example.comicvine.data.repository.SeriesRepo;
import com.example.comicvine.data.repository.StoriesRepo;

import java.util.List;

public class VineViewModel extends AndroidViewModel {

    private LiveData<List<IssuesResults>> getAllIssues;
    private LiveData<List<IssuesResults>> getAllVenom;
    private LiveData<List<IssuesResults>> getAllIronMan;
    private LiveData<List<IssuesResults>> getAllWolverine;
    private LiveData<List<IssuesResults>> getAllCaptainMarvel;
    private LiveData<List<IssuesResults>> getAllAvengers;
    private LiveData<List<IssuesResults>> getIssuesByName;
    private LiveData<List<ResultsByCharacters>> getAllCharacters;
    private LiveData<List<ResultsByCharacters>> getCharacterByName;
    private LiveData<List<ResultsByCharacters>> getAllStories;
    private LiveData<List<ResultBySeries>> getAllSeries;
    private LiveData<List<ResultByMovies>> getAllMovies;

    private LiveData<ResultsById> byIdLiveData;

    private IssuesRepo issuesRepo;
    private CharactersRepo charactersRepo;
    private StoriesRepo storiesRepo;
    private SeriesRepo seriesRepo;
    private MoviesRepo moviesRepo;

    public VineViewModel(@NonNull Application application) {
        super(application);

        issuesRepo=IssuesRepo.getInstance(application);
        getAllIssues=issuesRepo.getAllIssues();
        getAllVenom=issuesRepo.getAllVenom();
        getAllIronMan=issuesRepo.getAllIronMan();
        getAllWolverine=issuesRepo.getAllWolverine();
        getAllCaptainMarvel=issuesRepo.getAllCaptainMarvel();
        getAllAvengers=issuesRepo.getAllAvengers();

        charactersRepo=CharactersRepo.getInstance(application);
        getAllCharacters=charactersRepo.getAllCharacters();

        storiesRepo=StoriesRepo.getInstance(application);
        getAllStories=storiesRepo.getAllStories();

        seriesRepo=SeriesRepo.getInstance(application);
        getAllSeries=seriesRepo.getAllSeries();

        moviesRepo=MoviesRepo.getInstance(application);
        getAllMovies=moviesRepo.getAllMovies();

    }

    public void getIssueById(String id){

        byIdLiveData =issuesRepo.getIssuesById(id);
        Log.d("QQQ", "onResponse: " + "viewModel");
    }

    public void getCharacterbyName(String name){
        getCharacterByName=charactersRepo.getCharacterByName(name);
        getIssuesByName=charactersRepo.getCharacterIssuesBy(name);
    }


    public LiveData<ResultsById> getByIdLiveData() {

        return byIdLiveData;
    }

    public LiveData<List<IssuesResults>> getGetAllIssues() {
        return getAllIssues;
    }

    public LiveData<List<IssuesResults>> getGetAllVenom() {
        return getAllVenom;
    }

    public LiveData<List<IssuesResults>> getGetAllIronMan() {
        return getAllIronMan;
    }

    public LiveData<List<IssuesResults>> getGetAllWolverine() {
        return getAllWolverine;
    }

    public LiveData<List<IssuesResults>> getGetAllCaptainMarvel() {
        return getAllCaptainMarvel;
    }

    public LiveData<List<IssuesResults>> getGetAllAvengers() {
        return getAllAvengers;
    }

    public LiveData<List<ResultsByCharacters>> getGetAllCharacters() {
        return getAllCharacters;
    }

    public LiveData<List<ResultsByCharacters>> getGetAllStories() {
        return getAllStories;
    }

    public LiveData<List<ResultBySeries>> getGetAllSeries() {
        return getAllSeries;
    }

    public LiveData<List<ResultByMovies>> getGetAllMovies() {
        return getAllMovies;
    }

    public LiveData<List<ResultsByCharacters>> getGetCharacterByName() {
        return getCharacterByName;
    }

    public LiveData<List<IssuesResults>> getGetIssuesByName() {
        return getIssuesByName;
    }
}
