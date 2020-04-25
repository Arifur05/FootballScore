package com.arifur.footballscore.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Api.Statistics_Api;
import com.arifur.footballscore.Model.Model.Api;
import com.arifur.footballscore.Model.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.Model.Model.Teams;
import com.arifur.footballscore.Model.Model.Topscorer;
import com.arifur.footballscore.R;
import com.arifur.footballscore.ViewModels.TopScorerAdapter;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Top_Scorer extends AppCompatActivity {
    TextView pos, pname, pgoals, pteamName;
    ImageView teamLogo;

    RecyclerView scorerRecycler;
    TopScorerAdapter scorerAdapter;
    String plogo;
    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__scorer);
        pos=findViewById(R.id.player_position);
        pname=findViewById(R.id.player_name);
        pgoals=findViewById(R.id.number_of_goals);
        pteamName=findViewById(R.id.player_team_name);
        teamLogo=findViewById(R.id.team_logo);

        MaterialToolbar toolbar=findViewById(R.id.toolbar);

        alertDialogBuilder=new AlertDialog.Builder(Top_Scorer.this);
        alertDialogBuilder.setView(R.layout.progress_dialog);
        alertDialog=alertDialogBuilder.create();

        scorerRecycler=findViewById(R.id.score_recycler);

        scorerRecycler.setHasFixedSize(true);
        scorerRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getTopScorer();


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private void getTopScorer() {
        alertDialog.show();
        Call<FootballScoreLiveBaseModel> topScoreCall=Statistics_Api.getTopScorersService().getTopScorers();
        topScoreCall.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel standingModel=response.body();
                assert standingModel != null;

                Api api1=standingModel.getApi();
                List<Topscorer> topscorers=api1.getTopscorers();
                pos.setText("1");
                pname.setText(topscorers.get(0).getFirstname() + " " + topscorers.get(0).getLastname());
                pgoals.setText(topscorers.get(0).getGoals().getTotal().toString());
                pteamName.setText(topscorers.get(0).getTeamName());
                plogo=api1.getTopscorers().get(0).getTeamName();


                topscorers.remove(0);

                Call<FootballScoreLiveBaseModel> teamsCall=Statistics_Api.getTopScorersService().getTeams();
                teamsCall.enqueue(new Callback<FootballScoreLiveBaseModel>() {
                    @Override
                    public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                        FootballScoreLiveBaseModel baseModel=response.body();

                        assert baseModel != null;
                        Api api=baseModel.getApi();
                        List<Teams> teams=api.getTeams();

                        for (int i=0; !(i > teams.size()); i++) {
                            String name=teams.get(i).getName();
                            if (plogo.equals(name)) {
                                String teamslogo=teams.get(i).getLogo();
                                try {
                                    Glide.with(Top_Scorer.this).load(teamslogo).into(teamLogo);
                                } catch (Exception e) {
                                }
                                break;
                            }
                        }

                        scorerAdapter=new TopScorerAdapter(getApplicationContext(), topscorers, teams);
                        scorerRecycler.setAdapter(scorerAdapter);
                        scorerAdapter.notifyItemChanged(0, scorerAdapter.getItemCount());
                        alertDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {

                    }
                });


            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {

            }

        });


    }

}
