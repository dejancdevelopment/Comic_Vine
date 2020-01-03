package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.model.Response;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CharactersRepo {

    private CallApi callApi;
    public static CharactersRepo INSTANCE;
    private String API_KEY= BuildConfig.apikey;

    MutableLiveData<List<IssuesResults>> setAllCharacters =new MutableLiveData<>();

    public static CharactersRepo getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE=new CharactersRepo();

            CallApi callApi= ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;

    }

    public MutableLiveData<List<IssuesResults>> getAllSeries() {

        callApi.getCharactersResponse(API_KEY,"cover_date:desc","json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                setAllCharacters.setValue(response.body().getResultList());

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return setAllCharacters;
    }



    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
