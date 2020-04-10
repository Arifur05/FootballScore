package com.arifur.footballscore.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arifur.footballscore.Model.Fixtures.Api;
import com.arifur.footballscore.Model.Fixtures.LeagueFixtureModel;
import com.arifur.footballscore.R;
import com.arifur.footballscore.Api.ScoreApi;
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
        View view = inflater.inflate(R.layout.fragment_match_schedule, container, false);
        recyclerView = view.findViewById(R.id.fixtureRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        livematch=view.findViewById(R.id.livematches);
        livematch.setLayoutManager(new LinearLayoutManager(getContext()));
       // getFixture();
        getNextFixture();

        // Inflate the layout for this fragment
        return view;
    }


    private void getNextFixture() {
        Call<LeagueFixtureModel> scoreList = ScoreApi.getscoreService().getScoreList();
        scoreList.enqueue(new Callback<LeagueFixtureModel>() {
            @Override
            public void onResponse(Call<LeagueFixtureModel> call, Response<LeagueFixtureModel> response) {
                LeagueFixtureModel footballscoreList = response.body();
                //Api api=footballscoreList.getApi();
                    adapter= new NextFixtureAdapter(getContext(), footballscoreList.getApi().getFixtures());
                    recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<LeagueFixtureModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void getFixture(){
        Call<LeagueFixtureModel> fixtureList= ScoreApi.getFixtureInPlay().getLiveFixture();
        fixtureList.enqueue(new Callback<LeagueFixtureModel>() {
            @Override
            public void onResponse(Call<LeagueFixtureModel> call, Response<LeagueFixtureModel> response) {
                LeagueFixtureModel fixtureModelList=response.body();
                Api api= fixtureModelList.getApi();

               liveFixtureAdapter = new LiveFixtureAdapter(getContext(),api.getFixtures());
                livematch.setAdapter(liveFixtureAdapter);
            }

            @Override
            public void onFailure(Call<LeagueFixtureModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
