package com.test.a050_009_036_34_uas_ga.API;

import com.test.a050_009_036_34_uas_ga.MODEL.ListLocationModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("JsonDisplayMarket.php")
    Call<ListLocationModel> getAllLocation();
}
