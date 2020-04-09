package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.Fixtures.Fixture;
import com.arifur.footballscore.R;

import java.util.List;

public class LiveFixtureAdapter extends RecyclerView.Adapter<LiveFixtureAdapter.LiveFixtureViewHolder> {
    private Context context;
    private List<Fixture> fixtureList;

    public LiveFixtureAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    @NonNull
    @Override
    public LiveFixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.match_in_fixture, parent, false);

        return new LiveFixtureAdapter.LiveFixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveFixtureViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }


    public class LiveFixtureViewHolder extends RecyclerView.ViewHolder {

        ImageView homeTeam, awayTeam;
        TextView homeSocre, awayScore;
        public LiveFixtureViewHolder(@NonNull View itemView) {

            super(itemView);
            homeTeam = (TextView) itemView.findViewById(R.id.home_Team);
            round = itemView.findViewById(R.id.leagueRound);
            childRecyclerView = itemView.findViewById(R.id.childRecycler);

            leagueName.setText("English Premier League");
        }
    }
}
