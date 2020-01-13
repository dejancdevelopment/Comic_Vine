package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_episodes.EpisodesResult;
import com.example.comicvine.data.model.model_series.ResultBySeries;
import com.example.comicvine.data.model.model_series_by_id.ResultSeriesById;
import com.example.comicvine.data.repository.SeriesRepo;

import java.util.List;

public class SeriesViewModel extends AndroidViewModel {

    private SeriesRepo seriesRepo;

    public SeriesViewModel(@NonNull Application application) {
        super(application);

        seriesRepo=SeriesRepo.getInstance(application);
    }

    public LiveData<ResultSeriesById> getGetSeriesById(String id) {
        return seriesRepo.getSetSeriesById(id);
    }

    public LiveData<EpisodesResult> getGetEpisodesById(String id) {
        return seriesRepo.getEpisodesById(id);
    }

    public LiveData<List<ResultBySeries>> getGetAllSeries() {
        return seriesRepo.getAllSeries();
    }
}
