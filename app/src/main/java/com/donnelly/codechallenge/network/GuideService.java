package com.donnelly.codechallenge.network;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Steve on 6/19/2017.
 */

public class GuideService {
    private static GuideService guideService;
    protected Retrofit retrofit;
    protected GuideApi api;

    private static final String baseUrl = " https://guidebook.com";

    @NonNull
    public static GuideService getInstance(){
        if (guideService == null){
            guideService = new GuideService();
        }
        return guideService;
    }

    public GuideApi setup(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GuideApi.class);
        return api;
    }
}
