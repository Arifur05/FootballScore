package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.RoundsModel.Match;
import com.arifur.footballscore.Model.RoundsModel.Round;
import com.arifur.footballscore.R;

import java.util.List;

public class RoundScoreAdapter extends RecyclerView.Adapter<RoundScoreAdapter.RoundScoreViewHolder> {
    private Context context;
    private List<Match> mMatchList;

    public RoundScoreAdapter(Context context, List<Match>mMatchList ) {
        this.context=context;
        this.mMatchList=mMatchList;

    }

    @NonNull
    @Override
    public RoundScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.scores, parent, false);
        return new RoundScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoundScoreViewHolder holder, int position) {

        Match match= mMatchList.get(position);
        holder.homeTeam.setText(match.getTeam1().getName());
        holder.homeScore.setText(match.getScore1().toString());
        holder.awayScore.setText(match.getScore2().toString());
        holder.awayTeam.setText(match.getTeam2().getName());

    }

    @Override
    public int getItemCount() {
        return mMatchList.size();
    }

    public class RoundScoreViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, homeScore, awayScore;

        public RoundScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeam=itemView.findViewById(R.id.hometeam);
            homeScore=itemView.findViewById(R.id.homescore);
            awayScore=itemView.findViewById(R.id.awayscore);
            awayTeam=itemView.findViewById(R.id.awayteam);
        }
    }
}
