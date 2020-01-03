package com.example.comicvine.data.retrofit;

import com.example.comicvine.data.model.Response;
import com.example.comicvine.data.model_by_id.ResponseById;
import com.example.comicvine.data.model_characters.ResponseByCharacters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallApi {


    @GET("issues/")
    Call<Response> getAllIssuesResponse(@Query("api_key") String API_KEY,
                                        @Query("sort") String sortBy,
                                        @Query("format") String format);

    @GET("issues/")
    Call<Response> getAllIssuesByCharacter(@Query("api_key") String API_KEY,
                                           @Query("sort") String sort,
                                           @Query("filter") String sortBy,
                                           @Query("format") String format);

    @GET("issue/{id}/")
    Call<ResponseById> getIssueById (@Path ("id") String id,
                                     @Query("api_key") String API_KEY,
                                     @Query("format") String format);

    @GET("characters/")
    Call<ResponseByCharacters> getCharactersResponse(@Query("api_key") String API_KEY,
                                                     @Query("format") String format);

    @GET("story_arcs/")
    Call<ResponseByCharacters> getStoriesResponse(@Query("api_key") String API_KEY,
                                                     @Query("format") String format);

//    @GET("issues/")
//    Call<Response> getIssuesResponse(@Query("api_key") String API_KEY,
//                                     @Query("limit") int limitNumber,
//                                     @Query("sort") String sortBy,
//                                     @Query("format") String format);


//    @GET("issues/")
//    Call<Response> getIssuesByCharacter(@Query("api_key") String API_KEY,
//                                        @Query("limit") int limitNumber,
//                                        @Query("sort") String sort,
//                                        @Query("filter") String sortBy,
//                                        @Query("format") String format);


//    @GET("promos/")
//    Call<Response> getPromos(@Query("api_key") String API_KEY,
//                                   @Query("format") String format);

}
