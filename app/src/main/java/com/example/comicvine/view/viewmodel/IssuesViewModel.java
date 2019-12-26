package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.repository.IssuesRepo;

import java.util.List;

public class IssuesViewModel extends AndroidViewModel {

    LiveData<List<IssuesResults>> getIssues;
    LiveData<List<IssuesResults>> getVenom;
    LiveData<List<IssuesResults>> getIronMan;
    LiveData<List<IssuesResults>> getWolverine;

    LiveData<List<IssuesResults>> getLiveDataDb;

    public IssuesViewModel(@NonNull Application application) {
        super(application);

        IssuesRepo issuesRepo=IssuesRepo.getInstance(application);
        getIssues=issuesRepo.getIssues();
        getVenom=issuesRepo.getVenom();
        getIronMan=issuesRepo.getIronMan();
        getWolverine=issuesRepo.getWolverine();

        getLiveDataDb=issuesRepo.getIssuesIfResponse();
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
}
