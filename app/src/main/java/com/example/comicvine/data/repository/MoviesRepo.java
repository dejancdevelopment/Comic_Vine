package com.example.comicvine.data.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.model_movies.ResponseByMovies;
import com.example.comicvine.data.model.model_movies.ResultByMovies;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRepo {

    private CallApi callApi;
    public static MoviesRepo INSTANCE;
    private String API_KEY= BuildConfig.apikey;

    MutableLiveData<List<ResultByMovies>> setAllMovies =new MutableLiveData<>();

    public static MoviesRepo getInstance(Context context){

        if(INSTANCE==null){
            INSTANCE=new MoviesRepo();

            CallApi callApi= ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;
    }

    public MutableLiveData<List<ResultByMovies>> getAllMovies() {

     callApi.getMoviesResponse(API_KEY,"json").enqueue(new Callback<ResponseByMovies>() {
         @Override
         public void onResponse(Call<ResponseByMovies> call, Response<ResponseByMovies> response) {

             if (response.body() != null) {
                 setAllMovies.setValue(response.body().getMovieList());
             }
         }

         @Override
         public void onFailure(Call<ResponseByMovies> call, Throwable t) {

         }
     });

       return setAllMovies;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
