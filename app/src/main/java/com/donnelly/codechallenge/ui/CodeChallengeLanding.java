package com.donnelly.codechallenge.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.donnelly.codechallenge.R;
import com.donnelly.codechallenge.network.GuideApi;
import com.donnelly.codechallenge.network.GuideService;
import com.donnelly.codechallenge.network.models.Guide;
import com.donnelly.codechallenge.network.models.GuideResponse;
import com.donnelly.codechallenge.ui.adapter.GuideAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CodeChallengeLanding extends AppCompatActivity {

    private List<Guide> guides;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GuideAdapter guideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_challenge_landing);

        recyclerView = (RecyclerView)findViewById(R.id.guide_list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        guideAdapter = new GuideAdapter(CodeChallengeLanding.this);
        initGuides();
    }

    private void initGuides(){
        GuideApi api = GuideService.getInstance().setup();
        Call<GuideResponse> call = api.getGuides();

        call.enqueue(new Callback<GuideResponse>(){
            @Override
            public void onResponse(Call<GuideResponse> call, Response<GuideResponse> response) {
                // populate recyclerView
                guideAdapter.setData(response.body().getGuides());
                recyclerView.setAdapter(guideAdapter);
                guideAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GuideResponse> call, Throwable t) {
                //TODO: Some kind of error handling here
                System.out.println("reached onFailure: " + t.getMessage());
            }
        });
    }

}
