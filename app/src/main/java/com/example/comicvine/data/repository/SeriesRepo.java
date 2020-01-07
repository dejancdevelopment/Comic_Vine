package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.model_series.ResponseBySeries;
import com.example.comicvine.data.model.model_series.ResultBySeries;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesRepo {

    private CallApi callApi;
    public static SeriesRepo INSTANCE;
    private String API_KEY= BuildConfig.apikey;

    MutableLiveData<List<ResultBySeries>> setAllSeries =new MutableLiveData<>();

    public static SeriesRepo getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE=new SeriesRepo();

            CallApi callApi= ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;

    }

    public MutableLiveData<List<ResultBySeries>> getAllSeries() {

        callApi.getSeriesResponse(API_KEY,11,"json").enqueue(new Callback<ResponseBySeries>() {
            @Override
            public void onResponse(Call<ResponseBySeries> call, Response<ResponseBySeries> response) {

                if (response.body() != null) {
                    setAllSeries.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<ResponseBySeries> call, Throwable t) {

            }
        });

       return setAllSeries;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
