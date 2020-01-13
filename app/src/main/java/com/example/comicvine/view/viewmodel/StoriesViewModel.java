package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;
import com.example.comicvine.data.repository.StoriesRepo;

import java.util.List;

public class StoriesViewModel extends AndroidViewModel {

    private StoriesRepo storiesRepo;

    public StoriesViewModel(@NonNull Application application) {
        super(application);

        storiesRepo=StoriesRepo.getInstance(application);
    }

    public LiveData<List<ResultsByCharacters>> getGetAllStories() {
        return storiesRepo.getAllStories();
    }

    public LiveData<ResultsStoryById> getGetStorieById(String id) {
        return storiesRepo.getStoryiesById(id);
    }
}
