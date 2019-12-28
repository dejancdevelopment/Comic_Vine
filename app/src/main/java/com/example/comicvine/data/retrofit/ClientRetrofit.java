package com.example.comicvine.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRetrofit {

    private CallApi callApi;
    public static ClientRetrofit INSTANCE;
    public static final String BASE_URL="https://comicvine.gamespot.com/api/";

    public static ClientRetrofit getInstance(){

        if(INSTANCE==null){
            INSTANCE=new ClientRetrofit();
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CallApi callApi=retrofit.create(CallApi.class);
            INSTANCE.setCallApi(callApi);
        }
        return INSTANCE;
    }

    public CallApi getCallApi() {
        return callApi;
    }

    public void setCallApi(CallApi callApi) {
        this.callApi = callApi;
    }
}
