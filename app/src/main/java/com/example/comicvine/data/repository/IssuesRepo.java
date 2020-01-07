package com.example.comicvine.data.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.dbase.MyDao;
import com.example.comicvine.data.dbase.RoomDataBase;
import com.example.comicvine.data.model.model_issues.IssuesResults;
import com.example.comicvine.data.model.model_issues.Response;
import com.example.comicvine.data.model.model_by_id.ResponseById;
import com.example.comicvine.data.model.model_by_id.ResultsById;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;

public class IssuesRepo {

    private CallApi callApi;
    private MyDao myDao;
    public static IssuesRepo INSTANCE;

    private String API_KEY= BuildConfig.apikey;

    private Context context;

    private LiveData<List<IssuesResults>> getAllIssuesDb;
    private MutableLiveData<List<IssuesResults>> allIssues=new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> venomAllMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> ironAllManMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> wolverineAllManMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> captainMarvelAllMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> avengersAllMarvelMutableData = new MutableLiveData<>();
    private MutableLiveData<ResultsById> byIdMutableData = new MutableLiveData<>();
//    private IssuesRepo(Context context) {
//        this.context = context;
//    }

    public static IssuesRepo getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new IssuesRepo();

            CallApi callApi = ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);

            MyDao myDao = RoomDataBase.getInstance(context).myDao();
            INSTANCE.setMyDao(myDao);
        }
        return INSTANCE;
    }

    public MutableLiveData<List<IssuesResults>> getAllIssues() {

        callApi.getAllIssuesResponse(API_KEY,"cover_date:desc","json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.body() != null) {
                    allIssues.setValue(response.body().getResultList());
                }
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });

        return  allIssues;
    }

    public MutableLiveData<List<IssuesResults>> getAllVenom() {

       callApi.getAllIssuesByCharacter(API_KEY,"cover_date:desc","name:venom","json")
               .enqueue(new Callback<Response>() {
           @Override
           public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

               if (response.body() != null) {
                   venomAllMutableData.setValue(response.body().getResultList());
               }
           }

           @Override
           public void onFailure(Call<Response> call, Throwable t) {

           }
       });

      return venomAllMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getAllIronMan() {

        callApi.getAllIssuesByCharacter(API_KEY,"cover_date:desc","name:iron_man","json")
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                        if (response.body() != null) {
                            ironAllManMutableData.setValue(response.body().getResultList());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

        return ironAllManMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getAllWolverine() {

        callApi.getAllIssuesByCharacter(API_KEY,"cover_date:desc","name:wolverine","json")
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                        if (response.body() != null) {
                            wolverineAllManMutableData.setValue(response.body().getResultList());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

        return wolverineAllManMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getAllCaptainMarvel() {

        callApi.getAllIssuesByCharacter(API_KEY,"cover_date:desc","name:captain_marvel","json")
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                        if (response.body() != null) {
                            captainMarvelAllMutableData.setValue(response.body().getResultList());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

        return captainMarvelAllMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getAllAvengers () {

        callApi.getAllIssuesByCharacter(API_KEY,"cover_date:desc","name:avengers","json")
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                        if (response.body() != null) {
                            avengersAllMarvelMutableData.setValue(response.body().getResultList());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

        return avengersAllMarvelMutableData;
    }

    public MutableLiveData<ResultsById> getIssuesById (String id){

        callApi.getIssueById(id,API_KEY,"json").enqueue(new Callback<ResponseById>() {
            @Override
            public void onResponse(Call<ResponseById> call, retrofit2.Response<ResponseById> response) {

                if (response.body() != null) {
                    byIdMutableData.setValue(response.body().getResultList());
                }

                Log.d("QQQ", "onResponse: " + "onResponse");
            }

            @Override
            public void onFailure(Call<ResponseById> call, Throwable t) {


            }
        });

        return byIdMutableData;
    }

//    public MutableLiveData<List<IssuesResults>> getPromos() {//TODO not working json parser problem
//
//        callApi.getPromos(API_KEY,"json").enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//
//                promosMutableData.setValue(response.body().getResultList());
//
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//
//                Log.d("PROMOS", "onFailure: " + t);
//
//            }
//        });
//
//        return promosMutableData;
//    }


    //****
    //TODO ROOM
//    public LiveData<List<IssuesResults>> getIssuesIfResponse(){
//
//        LiveData<List<IssuesResults>> getAllIssues;
//
//        if(NetworkUtils.isConnectedAvailable(context)){
//
//            getAllIssues=getIssues();
//        }else {
//
//            getAllIssues=getAllFromDao();
//        }
//            return getAllIssues;
//    }
//    public LiveData<List<IssuesResults>> getAllFromDao() {
//
//      return getAllIssuesDb =myDao.getAllIssuesFromDao();
//    }
//    public LiveData<List<IssuesResults>> getGetAllIssuesDb() {
//        return getAllIssuesDb;
//    }

    private void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }

    private void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }
}
