package com.example.comicvine.data.retrofit;

import com.example.comicvine.data.model.model_episodes.EpisodesResponse;
import com.example.comicvine.data.model.model_issues.Response;
import com.example.comicvine.data.model.model_by_id.ResponseById;
import com.example.comicvine.data.model.model_characters.ResponseByCharacters;
import com.example.comicvine.data.model.model_movie_by_id.MovieByIdResponse;
import com.example.comicvine.data.model.model_movies.ResponseByMovies;
import com.example.comicvine.data.model.model_series.ResponseBySeries;
import com.example.comicvine.data.model.model_series_by_id.ResponseSeriesById;
import com.example.comicvine.data.model.model_story_by_id.ResponseStoryById;

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

    @GET("issues/")
    Call<Response> getCharacterIssuesAppearance(@Query("api_key") String API_KEY,
                                                @Query("sort") String sort,
                                                @Query("filter") String sortBy,
                                                @Query("format") String format);

    @GET("issue/{id}/")
    Call<ResponseById> getIssueById(@Path("id") String id,
                                    @Query("api_key") String API_KEY,
                                    @Query("format") String format);

    @GET("characters/")
    Call<ResponseByCharacters> getCharactersResponse(@Query("api_key") String API_KEY,
                                                     @Query("offset") String offset,
                                                     @Query("sort") String name,
                                                     @Query("format") String format);

    @GET("characters/")
    Call<ResponseByCharacters> getCharactersByName(@Query("api_key") String API_KEY,
                                                   @Query("filter") String name,
                                                   @Query("format") String format);

    @GET("story_arcs/")
    Call<ResponseByCharacters> getStoriesResponse(@Query("api_key") String API_KEY,
                                                  @Query("format") String format);

    @GET("story_arc/{id}")
    Call<ResponseStoryById> getStoriesByIdResponse(@Path("id") String id,
                                                   @Query("api_key") String API_KEY,
                                                   @Query("format") String format);

    @GET("series_list/")
    Call<ResponseBySeries> getSeriesResponse(@Query("api_key") String API_KEY,
                                             @Query("limit") int limitNumber,
                                             @Query("format") String format);

    @GET("series/{id}")
    Call<ResponseSeriesById> getSeriesByIdResponse(@Path("id") String id,
                                                   @Query("api_key") String API_KEY,
                                                   @Query("format") String format);

    @GET("movies/")
    Call<ResponseByMovies> getMoviesResponse(@Query("api_key") String API_KEY,
                                             @Query("format") String format);

    @GET("episode/{id}")
    Call<EpisodesResponse> getEpisodeById(@Path("id") String id,
                                          @Query("api_key") String API_KEY,
                                          @Query("format") String format);

    @GET("movie/{id}")
    Call<MovieByIdResponse> getMovieById(@Path("id") String id,
                                         @Query("api_key") String API_KEY,
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
