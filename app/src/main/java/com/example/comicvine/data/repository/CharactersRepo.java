package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.model_characters.ResponseByCharacters;
import com.example.comicvine.data.model.model_characters.ResultsByCharacters;
import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersRepo {

    private CallApi callApi;
    public static CharactersRepo INSTANCE;
    private String API_KEY= BuildConfig.apikey;

    MutableLiveData<List<ResultsByCharacters>> setAllCharacters =new MutableLiveData<>();
    MutableLiveData<List<ResultsByCharacters>> setCharacterByName =new MutableLiveData<>();
    MutableLiveData<List<IssuesResults>> setCharacterAppearance =new MutableLiveData<>();

    public static CharactersRepo getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE=new CharactersRepo();

            CallApi callApi= ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;

    }

    public MutableLiveData<List<ResultsByCharacters>> getAllCharacters() {

        callApi.getCharactersResponse(API_KEY,"68","date_last_updated:desc","json").enqueue(new Callback<ResponseByCharacters>() {
            @Override
            public void onResponse(Call<ResponseByCharacters> call, Response<ResponseByCharacters> response) {

                if (response.body() != null) {
                    setAllCharacters.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<ResponseByCharacters> call, Throwable t) {

            }
        });

        return setAllCharacters;
    }

    public MutableLiveData<List<ResultsByCharacters>> getCharacterByName (String name){


        callApi.getCharactersByName(API_KEY,"name:"+name,"json").enqueue(new Callback<ResponseByCharacters>() {
            @Override
            public void onResponse(Call<ResponseByCharacters> call, Response<ResponseByCharacters> response) {

                setCharacterByName.setValue(response.body().getResultList());
            }

            @Override
            public void onFailure(Call<ResponseByCharacters> call, Throwable t) {

            }
        });

        return setCharacterByName;
    }

    public MutableLiveData<List<IssuesResults>> getCharacterIssuesBy (String name){

        callApi.getCharacterIssuesAppearance(API_KEY,"cover_date:desc","name:"+name,"json")
                .enqueue(new Callback<com.example.comicvine.data.model.model_issues.Response>() {
                    @Override
                    public void onResponse(Call<com.example.comicvine.data.model.model_issues.Response> call, Response<com.example.comicvine.data.model.model_issues.Response> response) {

                        setCharacterAppearance.setValue(response.body().getResultList());
                    }

                    @Override
                    public void onFailure(Call<com.example.comicvine.data.model.model_issues.Response> call, Throwable t) {

                    }
                });


        return setCharacterAppearance;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
