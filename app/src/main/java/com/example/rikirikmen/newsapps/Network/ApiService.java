package com.example.rikirikmen.newsapps.Network;

import java.util.List;

import retrofit2.Call;
        import retrofit2.http.GET;

/**
 * Created by rikirikmen on 5/12/2016.
 */
public interface ApiService {



    @GET("v0/topstories.json?print=pretty")
    Call<List<Integer>> getTopStories();
}
