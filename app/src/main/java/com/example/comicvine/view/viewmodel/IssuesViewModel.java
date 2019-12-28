package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.model_by_id.ResultsById;
import com.example.comicvine.data.repository.IssuesRepo;

import java.util.List;

public class IssuesViewModel extends AndroidViewModel {

    LiveData<List<IssuesResults>> getIssues;
    LiveData<List<IssuesResults>> getAllIssues;

    LiveData<List<IssuesResults>> getVenom;
    LiveData<List<IssuesResults>> getAllVenom;

    LiveData<List<IssuesResults>> getIronMan;
    LiveData<List<IssuesResults>> getWolverine;
    LiveData<List<IssuesResults>> getCaptainMarvel;
    LiveData<List<IssuesResults>> getAvengers;
    LiveData<List<IssuesResults>> getPromos;
    LiveData<ResultsById> byIdLiveData;

    LiveData<List<IssuesResults>> getLiveDataDb;

    public IssuesViewModel(@NonNull Application application) {
        super(application);

        IssuesRepo issuesRepo=IssuesRepo.getInstance(application);
        getIssues=issuesRepo.getIssues();
        getAllIssues=issuesRepo.getAllIssues();

        getVenom=issuesRepo.getVenom();
        getAllVenom=issuesRepo.getAllVenom();

        getIronMan=issuesRepo.getIronMan();
        getWolverine=issuesRepo.getWolverine();
        getCaptainMarvel=issuesRepo.getCaptainMarvel();
        getAvengers=issuesRepo.getAvengers();
        getPromos=issuesRepo.getPromos();


        getLiveDataDb=issuesRepo.getIssuesIfResponse();
    }

    public void getIssueById(String id){

        IssuesRepo issuesRepo=IssuesRepo.getInstance(getApplication());
        byIdLiveData =issuesRepo.getIssuesById(id);

    }

    public LiveData<List<IssuesResults>> getGetIssues() {
        return getIssues;
    }

    public LiveData<List<IssuesResults>> getGetVenom() {
        return getVenom;
    }

    public LiveData<List<IssuesResults>> getGetIronMan() {
        return getIronMan;
    }

    public LiveData<List<IssuesResults>> getGetWolverine() {
        return getWolverine;
    }

    public LiveData<List<IssuesResults>> getGetLiveDataDb() {
        return getLiveDataDb;
    }

    public LiveData<List<IssuesResults>> getGetCaptainMarvel() {
        return getCaptainMarvel;
    }

    public LiveData<List<IssuesResults>> getGetAvengers() {
        return getAvengers;
    }

    public LiveData<List<IssuesResults>> getGetPromos() {
        return getPromos;
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
}
