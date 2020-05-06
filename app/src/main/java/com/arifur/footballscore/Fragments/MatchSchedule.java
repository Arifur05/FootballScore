package com.arifur.footballscore.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Api.ScoreApi;
import com.arifur.footballscore.Model.Api;
import com.arifur.footballscore.Model.Fixture;
import com.arifur.footballscore.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.Model.RoundsModel.FootballRoundsModel;
import com.arifur.footballscore.Model.RoundsModel.Match;
import com.arifur.footballscore.Model.RoundsModel.Round;
import com.arifur.footballscore.R;
import com.arifur.footballscore.ViewModels.LiveFixtureAdapter;
import com.arifur.footballscore.ViewModels.NextFixtureAdapter;
import com.arifur.footballscore.ViewModels.RoundScoreAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchSchedule extends Fragment {

    Spinner moundSpinner;
    List<String> mRounds=new ArrayList<>();
    private RecyclerView nextFixture, livematch, mroundScore;
    private NextFixtureAdapter adapter;
    private LiveFixtureAdapter liveFixtureAdapter;
    private TextView mlive;
    private RoundScoreAdapter roundScoreAdapter;
    List<Match> matches= new ArrayList<>();
    public MatchSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_match_schedule, container, false);
        nextFixture=view.findViewById(R.id.fixtureRecycler);
        nextFixture.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        livematch=view.findViewById(R.id.livematches);
        livematch.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mlive=view.findViewById(R.id.livematchestext);
        moundSpinner=view.findViewById(R.id.round_spinner);
        mroundScore= view.findViewById(R.id.round_score_view);
        mroundScore.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        getLiveFixture();
        getNextFixture();

        getRoundScore();


        return view;
    }

    private void getRoundScore() {
        Call<FootballRoundsModel> footballRoundsModelCall=ScoreApi.getScoreRounded().getRoundScore();
        footballRoundsModelCall.enqueue(new Callback<FootballRoundsModel>() {
            @Override
            public void onResponse(Call<FootballRoundsModel> call, Response<FootballRoundsModel> response) {
                FootballRoundsModel footballRoundsModel=response.body();
                assert footballRoundsModel != null;
                List<Round> mRoundList=footballRoundsModel.getRounds();
                for (int iterator=0; iterator < mRoundList.size(); iterator++) {
                    mRounds.add(iterator, mRoundList.get(iterator).getName());
                    ArrayAdapter<String> spinnerArrayAdapter=new ArrayAdapter<String>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, mRounds);
                    //spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    moundSpinner.setAdapter(spinnerArrayAdapter);
                }
                moundSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Integer roundName=moundSpinner.getSelectedItemPosition();
                       // Toast.makeText(getContext(),"Selected" + roundName, Toast.LENGTH_LONG).show(;

                        for (int i =0; i<mRoundList.size(); i++){
                            if (i== roundName){
                                matches= mRoundList.get(i).getMatches();
                            }
                        }
                        roundScoreAdapter=new RoundScoreAdapter(getContext(),matches);
                        mroundScore.setAdapter(roundScoreAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }

            @Override
            public void onFailure(Call<FootballRoundsModel> call, Throwable t) {

            }
        });
    }


    private void getNextFixture() {
        Call<FootballScoreLiveBaseModel> scoreList=ScoreApi.getFixtureInPlay().getNextFixtures();
        scoreList.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel footballscoreList=response.body();
                if (footballscoreList != null) {
                    Api api=footballscoreList.getApi();
                    if (api != null) {
                        adapter=new NextFixtureAdapter(getContext(), api.getFixtures());
                    }
                    nextFixture.setAdapter(adapter);
                } else {
                    mlive.setVisibility(View.GONE);
                }
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
                if (fixtureModelList != null) {
                    mlive.setVisibility(View.VISIBLE);
                    Api api=fixtureModelList.getApi();
                    List<Fixture> fixture=api.getFixtures();

                    liveFixtureAdapter=new LiveFixtureAdapter(getContext(), fixture);
                    livematch.setAdapter(liveFixtureAdapter);
                    if (liveFixtureAdapter == null) {
                        mlive.setVisibility(View.GONE);
                    }
                }

            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please connect Data!", Toast.LENGTH_LONG).show();
            }
        });
    }
}