package com.example.comicvine.data.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.comicvine.BuildConfig;
import com.example.comicvine.data.dbase.MyDao;
import com.example.comicvine.data.dbase.RoomDataBase;
import com.example.comicvine.data.model.IssuesResults;
import com.example.comicvine.data.model.Response;
import com.example.comicvine.data.retrofit.CallApi;
import com.example.comicvine.data.retrofit.ClientRetrofit;
import com.example.comicvine.data.utils.NetworkUtils;

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

    private MutableLiveData<List<IssuesResults>> issuesMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> venomMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> ironManMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> wolverineManMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> captainMarvelMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> avangersMarvelMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> promosMutableData = new MutableLiveData<>();
    private MutableLiveData<List<IssuesResults>> byIdMutableData = new MutableLiveData<>();


    ///****
    public IssuesRepo(Context context) {
        this.context = context;
    }

    public static IssuesRepo getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new IssuesRepo(context);

            CallApi callApi = ClientRetrofit.getInstance().getCallApi();
            INSTANCE.setCallApi(callApi);

            MyDao myDao = RoomDataBase.getInstance(context).myDao();
            INSTANCE.setMyDao(myDao);
        }
        return INSTANCE;
    }

    public MutableLiveData<List<IssuesResults>> getIssues() {

        callApi.getIssuesResponse(API_KEY,25,"cover_date:desc","json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, final retrofit2.Response<Response> response) {

                if (response.body()!=null){
                    issuesMutableData.setValue(response.body().getResultList());
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        if(response.body()!=null){
                            myDao.setAllIssuesToDao(response.body().getResultList());
                        }
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return issuesMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getVenom() {

        callApi.getIssuesByCharacter(API_KEY, 25, 51, "name:venom", "json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.body() != null) {

                    venomMutableData.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return venomMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getIronMan() {

        callApi.getIssuesByCharacter(API_KEY, 25, 51, "name:iron_man", "json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.body() != null) {

                    ironManMutableData.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return ironManMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getWolverine() {

        callApi.getIssuesByCharacter(API_KEY, 25, 100, "name:wolverine", "json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.body() != null) {

                    wolverineManMutableData.setValue(response.body().getResultList());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return wolverineManMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getCaptainMarvel() {

        callApi.getIssuesByCharacter(API_KEY,25,100,"name:captain_marvel","json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if(response.body()!=null) {
                    captainMarvelMutableData.setValue(response.body().getResultList());
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return captainMarvelMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getAvengers () {

        callApi.getIssuesByCharacter(API_KEY,25,51,"name:avengers","json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if(response.body()!=null) {
                    avangersMarvelMutableData.setValue(response.body().getResultList());
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        return avangersMarvelMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getPromos() {

        callApi.getPromos(API_KEY,"json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                promosMutableData.setValue(response.body().getResultList());

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Log.d("PROMOS", "onFailure: " + t);

            }
        });

        return promosMutableData;
    }

    public MutableLiveData<List<IssuesResults>> getIssuesById (String id){

        callApi.getIssueById(id,API_KEY,"json").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                byIdMutableData.setValue(response.body().getResultList());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Log.d("WWW", "onFailure: " + t);

            }
        });

        return byIdMutableData;
    }

    ///****
    ///TODO
    public LiveData<List<IssuesResults>> getIssuesIfResponse(){

        LiveData<List<IssuesResults>> getAllIssues;

        if(NetworkUtils.isConnectedAvailable(context)){

            getAllIssues=getIssues();
        }else {

            getAllIssues=getAllFromDao();
        }
            return getAllIssues;
    }
    public LiveData<List<IssuesResults>> getAllFromDao() {

      return getAllIssuesDb =myDao.getAllIssuesFromDao();
    }
    public LiveData<List<IssuesResults>> getGetAllIssuesDb() {
        return getAllIssuesDb;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }

    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }
}
