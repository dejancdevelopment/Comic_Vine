package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.repository.CharactersRepo;

import java.util.List;

public class CharactersViewModel extends AndroidViewModel {

    private CharactersRepo charactersRepo;

    public CharactersViewModel(@NonNull Application application) {
        super(application);

        charactersRepo=CharactersRepo.getInstance(application);
    }

    public LiveData<List<ResultsByCharacters>> getGetAllCharacters() {
        return charactersRepo.getAllCharacters();
    }

    public LiveData<List<ResultsByCharacters>> getGetCharacterByName(String name) {
        return charactersRepo.getCharacterByName(name);
    }

    public LiveData<List<IssuesResults>> getGetIssuesByName(String name) {
        return charactersRepo.getCharacterIssuesBy(name);
    }
}
