package com.arifur.footballscore.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arifur.footballscore.Api.Statistics_Api;
import com.arifur.footballscore.R;
import com.arifur.footballscore.Model.StatModels.Api;
import com.arifur.footballscore.Model.StatModels.LeagueStatisticsModel;
import com.arifur.footballscore.ViewModels.StatisticsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Statistics extends Fragment {
    RecyclerView recyclerView;
    StatisticsAdapter adapter;

    TextView table;

    public Statistics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        table= view.findViewById(R.id.table);
        recyclerView = view.findViewById(R.id.standingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getStatistics();
        // Inflate the layout for this fragment
        return view;

    }

    private void getStatistics(){

        Call<LeagueStatisticsModel> standingList= Statistics_Api.getscoreService().getStandings();
        standingList.enqueue(new Callback<LeagueStatisticsModel>() {
            @Override
            public void onResponse(Call<LeagueStatisticsModel> call, Response<LeagueStatisticsModel> response) {
                LeagueStatisticsModel standingModel= response.body();
                Api api= standingModel.getApi();

                adapter= new StatisticsAdapter(getContext(), api.getStandings());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<LeagueStatisticsModel> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
