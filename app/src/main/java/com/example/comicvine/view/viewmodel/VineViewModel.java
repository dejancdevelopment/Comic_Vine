package com.example.comicvine.view.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.model_by_id.ResultsById;
import com.example.comicvine.data.repository.SeriesRepo;
import com.example.comicvine.data.repository.IssuesRepo;

import java.util.List;

public class VineViewModel extends AndroidViewModel {

    private LiveData<List<IssuesResults>> getAllIssues;
    private LiveData<List<IssuesResults>> getAllVenom;
    private LiveData<List<IssuesResults>> getAllIronMan;
    private LiveData<List<IssuesResults>> getAllWolverine;
    private LiveData<List<IssuesResults>> getAllCaptainMarvel;
    private LiveData<List<IssuesResults>> getAllAvengers;

    private LiveData<List<IssuesResults>> getAllSeries;

    //    private LiveData<List<IssuesResults>> getLiveDataDb;
    //    private LiveData<List<IssuesResults>> getPromos;

    private LiveData<ResultsById> byIdLiveData;

    private IssuesRepo issuesRepo;
    private SeriesRepo episodesRepo;

    public VineViewModel(@NonNull Application application) {
        super(application);

        issuesRepo=IssuesRepo.getInstance(application);
        getAllIssues=issuesRepo.getAllIssues();
        getAllVenom=issuesRepo.getAllVenom();
        getAllIronMan=issuesRepo.getAllIronMan();
        getAllWolverine=issuesRepo.getAllWolverine();
        getAllCaptainMarvel=issuesRepo.getAllCaptainMarvel();
        getAllAvengers=issuesRepo.getAllAvengers();

        episodesRepo= SeriesRepo.getInstance(application);
        getAllSeries =episodesRepo.getAllSeries();

//        getPromos=issuesRepo.getPromos();
//        getLiveDataDb=issuesRepo.getIssuesIfResponse();
    }

    public void getIssueById(String id){

        byIdLiveData =issuesRepo.getIssuesById(id);
        Log.d("QQQ", "onResponse: " + "viewModel");
    }

//    public LiveData<List<IssuesResults>> getGetPromos() {
//        return getPromos;
//    }

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

    public LiveData<List<IssuesResults>> getGetAllSeries() {
        return getAllSeries;
    }
}
