package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.model_characters.ResponseByCharacters;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_story_by_id.ResponseStoryById;
import com.example.comicvine.data.model.model_story_by_id.ResultsStoryById;
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

    private MutableLiveData<List<ResultsByCharacters>> setAllStories =new MutableLiveData<>();
    private MutableLiveData<ResultsStoryById> setStoriesById =new MutableLiveData<>();

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

    public MutableLiveData<ResultsStoryById> getStoryiesById(String id) {

        callApi.getStoriesByIdResponse(id,API_KEY,"json").enqueue(new Callback<ResponseStoryById>() {
            @Override
            public void onResponse(Call<ResponseStoryById> call, Response<ResponseStoryById> response) {

                if (response.body() != null) {
                    setStoriesById.setValue(response.body().getResultsStoryById());
                }
            }

            @Override
            public void onFailure(Call<ResponseStoryById> call, Throwable t) {

            }
        });
        return setStoriesById;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
