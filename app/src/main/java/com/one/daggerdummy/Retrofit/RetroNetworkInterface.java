package com.one.daggerdummy.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroNetworkInterface {
    @GET("/todos")
    Call<List<Data>> getToDoItems();
}
