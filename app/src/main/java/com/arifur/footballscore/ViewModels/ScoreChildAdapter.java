package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.Match;
import com.arifur.footballscore.R;

import java.util.List;

public class ScoreChildAdapter extends  RecyclerView.Adapter<ScoreChildAdapter.ScoreChildViewHolder> {

    private List<Match> matchList;
    private Context context;

    public ScoreChildAdapter(Context context,List<Match> matchList) {
        this.matchList = matchList;
        this.context = context;

    }

    @NonNull
    @Override
    public ScoreChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.scores, parent,false );
        return new ScoreChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreChildViewHolder holder, int position) {
        Match match= matchList.get(position);
        holder.homeTeam.setText(match.getTeam1().getName());
        holder.awayTeam.setText(match.getTeam2().getName());
        holder.homeScore.setText(match.getScore1().toString());
        holder.awayScore.setText(match.getScore2().toString());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public class ScoreChildViewHolder extends RecyclerView.ViewHolder {


        public TextView awayTeam, homeTeam, homeScore, awayScore;

        public ScoreChildViewHolder(@NonNull View itemView) {

            super(itemView);
            awayTeam = (TextView) itemView.findViewById(R.id.awayteam);
            homeTeam = (TextView) itemView.findViewById(R.id.hometeam);
            homeScore = (TextView) itemView.findViewById(R.id.homescore);
            awayScore = (TextView) itemView.findViewById(R.id.awayscore);


        }
    }


}
