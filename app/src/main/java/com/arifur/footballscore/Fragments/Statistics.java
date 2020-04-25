package com.arifur.footballscore.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Api.Statistics_Api;
import com.arifur.footballscore.Model.Model.Api;
import com.arifur.footballscore.Model.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.R;
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
    Button scorerButton;
    TextView table;
    View view;

    public Statistics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_statistics, container, false);
        table=view.findViewById(R.id.table);
        recyclerView=view.findViewById(R.id.standingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        scorerButton=view.findViewById(R.id.top_scorer_button);
        getStatistics();
        scorerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScorerPage();
            }
        });

        // Inflate the layout for this fragment
        return view;

    }

    private void getScorerPage() {

        Intent i=new Intent(getContext(), Top_Scorer.class);
        startActivity(i);
    }

    private void getStatistics() {

        Call<FootballScoreLiveBaseModel> standingList=Statistics_Api.getscoreService().getStandings();
        standingList.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel standingModel=response.body();
                Api api=standingModel.getApi();

                adapter=new StatisticsAdapter(getContext(), api.getStandings());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
