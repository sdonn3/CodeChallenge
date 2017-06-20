package com.donnelly.codechallenge.network;

import com.donnelly.codechallenge.network.models.Guide;
import com.donnelly.codechallenge.network.models.GuideResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;



/**
 * Created by Steve on 6/19/2017.
 */

public interface GuideApi {
    String API_VERSION = "/v2/";

    @GET("service" + API_VERSION + "upcomingGuides/")
    Call<GuideResponse> getGuides();
}
