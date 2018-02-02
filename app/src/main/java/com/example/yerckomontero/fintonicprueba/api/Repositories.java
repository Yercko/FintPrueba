package com.example.yerckomontero.fintonicprueba.api;

import android.content.Context;

import com.example.yerckomontero.fintonicprueba.data.UserData;
import com.example.yerckomontero.fintonicprueba.models.HeroesList;
import com.example.yerckomontero.fintonicprueba.operations.list.IListView;
import com.example.yerckomontero.fintonicprueba.utils.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yercko on 16/08/2017.
 */

public class Repositories {
    private static Repositories instance;
    private Retrofit retrofit;
    private ApiService api;
    public Repositories(){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.REMOTE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(clientBuilder.build())
                .build();
        api = retrofit.create(ApiService.class);

    }


    public void heroesRequest(final Context context, final IListView iListView){
        Call<HeroesList> call = api.getHeroes();
        call.enqueue(new Callback<HeroesList>() {
            @Override
            public void onResponse(Call<HeroesList> call, retrofit2.Response<HeroesList> response) {
                switch (response.code()) {
                    case 200:
                        UserData.getInstance(context).setHeroes(response.body());
                        iListView.onLoadSuccess(true);
                        break;
                    case 401:
                        iListView.onLoadSuccess(false);
                        break;
                    default:
                        iListView.onLoadSuccess(false);
                        break;
                }
            }
            @Override
            public void onFailure(Call<HeroesList> call, Throwable t) {
                iListView.onLoadSuccess(false);
            }
        });
    }
}