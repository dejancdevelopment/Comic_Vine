package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.model_characters.ResponseByCharacters;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoriesRepo {

    private CallApi callApi;
    public static StoriesRepo INSTANCE;
    private String API_KEY= BuildConfig.apikey;

    MutableLiveData<List<ResultsByCharacters>> setAllStories =new MutableLiveData<>();

    public static StoriesRepo getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE=new StoriesRepo();

            CallApi callApi= ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;

    }

    public MutableLiveData<List<ResultsByCharacters>> getAllStories() {

        callApi.getStoriesResponse(API_KEY,"json").enqueue(new Callback<ResponseByCharacters>() {
            @Override
            public void onResponse(Call<ResponseByCharacters> call, Response<ResponseByCharacters> response) {

                if (response.body() != null) {
                    setAllStories.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<ResponseByCharacters> call, Throwable t) {

            }
        });

        return setAllStories;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
