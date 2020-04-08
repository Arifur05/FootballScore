package com.arifur.footballscore.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arifur.footballscore.Model.Fixtures.League;
import com.arifur.footballscore.Model.Fixtures.LeagueFixtureModel;
import com.arifur.footballscore.Model.LeagueScoreModel;
import com.arifur.footballscore.R;
import com.arifur.footballscore.Api.ScoreApi;
import com.arifur.footballscore.ViewModels.ScoreAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchSchedule extends Fragment {

    RecyclerView recyclerView;
    ScoreAdapter adapter;
    //List<Round>  footballscoreList;
    public MatchSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_schedule, container, false);
        recyclerView = view.findViewById(R.id.scoreRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        getScore();
        getFixture();
        // Inflate the layout for this fragment
        return view;
    }


    private void getScore() {
        Call<LeagueScoreModel> scoreList = ScoreApi.getscoreService().getScoreList();
        scoreList.enqueue(new Callback<LeagueScoreModel>() {
            @Override
            public void onResponse(Call<LeagueScoreModel> call, Response<LeagueScoreModel> response) {
                LeagueScoreModel footballscoreList = response.body();

                    adapter= new ScoreAdapter(getContext(), footballscoreList.getRounds());
                    recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<LeagueScoreModel> call, Throwable t) {
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
                Toast.makeText(getContext(), "Successfull", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<LeagueFixtureModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
