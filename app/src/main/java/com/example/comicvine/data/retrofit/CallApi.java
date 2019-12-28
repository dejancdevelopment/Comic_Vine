package com.example.comicvine.data.retrofit;

import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallApi {

    @GET("issues/")
    Call<Response> getIssuesResponse(@Query("api_key") String API_KEY,
                                     @Query("limit") int limitNumber,
                                     @Query("sort") String sortBy,
                                     @Query("format") String format);

    @GET("issues/")
    Call<Response> getIssuesByCharacter (@Query("api_key") String API_KEY,
                                 @Query("limit") int limitNumber,
                                 @Query("offset") int offsetNumber,
                                 @Query("filter") String sortBy,
                                 @Query("format") String format);

    @GET("promos/")
    Call<Response> getPromos(@Query("api_key") String API_KEY,
                                   @Query("format") String format);


    @GET("issue/{id}/")
    Call<Response> getIssueById (@Path ("id") String id,
                                 @Query("api_key") String API_KEY,
                                    @Query("format") String format);
}
