package com.example.comicvine.data.retrofit;

import androidx.lifecycle.LiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallApi {

    @GET("issues/")
    Call<Response> getResponse(@Query("api_key") String API_KEY,
                                @Query("limit") int limitNumber,
                                @Query("sort") String sortBy,
                               @Query("format") String format);

    @GET("issues/")
    LiveData<Response> getResponseLive(@Query("api_key") String API_KEY,
                                   @Query("limit") int limitNumber,
                                   @Query("sort") String sortBy,
                                   @Query("format") String format);

    @GET("issues/")
    Call<Response> getVenom (@Query("api_key") String API_KEY,
                             @Query("limit") int limitNumber,
                             @Query("offset") int offsetNumber,
                             @Query("filter") String sortBy,
                             @Query("format") String format);

    @GET("issues/")
    Call<Response> getIronMan (@Query("api_key") String API_KEY,
                              @Query("limit") int limitNumber,
                              @Query("offset") int offsetNumber,
                             @Query("filter") String sortBy,
                             @Query("format") String format);

    @GET("issues/")
    Call<Response> getWolverine (@Query("api_key") String API_KEY,
                              @Query("limit") int limitNumber,
                              @Query("offset") int offsetNumber,
                              @Query("filter") String sortBy,
                              @Query("format") String format);
}
