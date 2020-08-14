package com.solution.toppop.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeezerApi {

    @GET("/chart")
    Call<ChartDTO> getChart();

    @GET("/album/{id}")
    Call<AlbumDTO> getAlbum(@Path("id") int albumId);
}
