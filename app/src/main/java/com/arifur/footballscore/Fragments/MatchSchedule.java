package com.arifur.footballscore.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Api.ScoreApi;
import com.arifur.footballscore.Model.Model.Api;
import com.arifur.footballscore.Model.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.R;
import com.arifur.footballscore.ViewModels.LiveFixtureAdapter;
import com.arifur.footballscore.ViewModels.NextFixtureAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchSchedule extends Fragment {

    RecyclerView recyclerView, livematch;
    NextFixtureAdapter adapter;
    LiveFixtureAdapter liveFixtureAdapter;

    public MatchSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_match_schedule, container, false);
        recyclerView=view.findViewById(R.id.fixtureRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        livematch=view.findViewById(R.id.livematches);
        livematch.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        getLiveFixture();

        getNextFixture();

        // Inflate the layout for this fragment
        return view;
    }


    private void getNextFixture() {
        Call<FootballScoreLiveBaseModel> scoreList=ScoreApi.getFixtureInPlay().getNextFixtures();
        scoreList.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel footballscoreList=response.body();
                Api api=null;
                if (footballscoreList != null) {
                    api=footballscoreList.getApi();
                }
                if (api != null) {
                    adapter=new NextFixtureAdapter(getContext(), api.getFixtures());
                }
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getLiveFixture() {
        Call<FootballScoreLiveBaseModel> fixtureList=ScoreApi.getFixtureInPlay().getLiveFixture();
        fixtureList.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel fixtureModelList=response.body();
                assert fixtureModelList != null;
                Api api=fixtureModelList.getApi();

                liveFixtureAdapter=new LiveFixtureAdapter(getContext(), api.getFixtures());
                livematch.setAdapter(liveFixtureAdapter);
            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
