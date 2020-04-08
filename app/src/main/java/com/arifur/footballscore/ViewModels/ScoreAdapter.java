package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.Round;
import com.arifur.footballscore.R;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {
    private Context context;
    private List<Round> roundscoreList;


    public ScoreAdapter(Context context, List<Round> roundscoreList) {
        this.context = context;
        this.roundscoreList = roundscoreList;
    }


    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.score_card, parent, false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {

        Round round = roundscoreList.get(position);
        holder.round.setText(round.getName());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);
        ScoreChildAdapter scoreChildAdapter = new ScoreChildAdapter(context, round.getMatches());
        holder.childRecyclerView.setAdapter(scoreChildAdapter);
    }

    @Override
    public int getItemCount() {
        return roundscoreList.size();
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {


        public TextView leagueName, round;
        RecyclerView childRecyclerView;

        public ScoreViewHolder(@NonNull View itemView) {

            super(itemView);
            leagueName = (TextView) itemView.findViewById(R.id.leagueName);
            round = itemView.findViewById(R.id.leagueRound);
            childRecyclerView = itemView.findViewById(R.id.childRecycler);

            leagueName.setText("English Premier League");
        }
    }
}
