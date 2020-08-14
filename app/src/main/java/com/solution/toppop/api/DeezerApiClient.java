package com.solution.toppop.api;

import android.app.Activity;
import android.util.Log;

import com.solution.toppop.details.AlbumDetailsActivity;
import com.solution.toppop.main.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeezerApiClient {

    DeezerApi deezerApi;
    Activity activity;
    String BASE_URL = "https://api.deezer.com";

    public DeezerApiClient(Activity activity) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        deezerApi = retrofit.create(DeezerApi.class);
        this.activity = activity;
    }

    public void getChart(){
        Call<ChartDTO> call = deezerApi.getChart();
        call.enqueue(new Callback<ChartDTO>() {

            @Override
            public void onResponse(Call<ChartDTO> call, Response<ChartDTO> response) {
                if (response.body() != null){
                    ((MainActivity)activity).processResponse(response.body());
                }
            }
            @Override
            public void onFailure(Call<ChartDTO> call, Throwable t) {
                Log.d("FAILURE", "Failure: " + t);
                return;
            }
        });
    }

    public void getAlbum(int albumId){
        Call<AlbumDTO> call = deezerApi.getAlbum(albumId);
        call.enqueue(new Callback<AlbumDTO>() {

            @Override
            public void onResponse(Call<AlbumDTO> call, Response<AlbumDTO> response) {
                if (response.body() != null){
                    ((AlbumDetailsActivity)activity).processResponse(response.body());
                }
            }
            @Override
            public void onFailure(Call<AlbumDTO> call, Throwable t) {
                Log.d("FAILURE", "Failure: " + t);
                return;
            }
        });
    }
}
