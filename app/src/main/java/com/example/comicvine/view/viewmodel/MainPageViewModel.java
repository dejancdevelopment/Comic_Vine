package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.model.model_by_id.ResultsById;

import com.example.comicvine.data.repository.IssuesRepo;


import java.util.List;

public class MainPageViewModel extends AndroidViewModel {

    private IssuesRepo issuesRepo;

    public MainPageViewModel(@NonNull Application application) {
        super(application);

        issuesRepo=IssuesRepo.getInstance(application);
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

}
