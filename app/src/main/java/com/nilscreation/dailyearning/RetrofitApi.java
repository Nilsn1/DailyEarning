package com.nilscreation.dailyearning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("DailyEarning.json")
    Call<List<ListModel>> myList();
}
