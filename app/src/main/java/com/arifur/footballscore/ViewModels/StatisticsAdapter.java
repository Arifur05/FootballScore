package com.arifur.footballscore.ViewModels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.R;
import com.arifur.footballscore.Model.StatModels.Standing;

import java.util.ArrayList;
import java.util.List;


public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder> {
    private Context context;
    private List<List<Standing>> standingList = new ArrayList<>();


    public StatisticsAdapter(Context context, List<List<Standing>> standingList) {
        this.context = context;
        this.standingList = standingList;
    }

    @NonNull
    @Override
    public StatisticsAdapter.StatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.standings_table, parent, false);
        return new StatisticsAdapter.StatisticsViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StatisticsViewHolder holder, int position) {

            Standing standing = (Standing) standingList.get(0).get(position);
            holder.teamNameTV.setText(standing.getTeamName());
            holder.pointsTV.setText(standing.getPoints().toString());
            holder.matchPlayedTV.setText(standing.getAll().getMatchsPlayed().toString());
            holder.positionTv.setText(standing.getRank().toString());
            holder.goal_diff.setText(standing.getGoalsDiff().toString());
            holder.form.setText(standing.getForme());
    }

    @Override
    public int getItemCount() {
        return standingList.get(0).size();
    }

    public class StatisticsViewHolder extends RecyclerView.ViewHolder {
        TextView positionTv, teamNameTV, matchPlayedTV, pointsTV, goal_diff, form;

        public StatisticsViewHolder(@NonNull View itemView) {
            super(itemView);
            positionTv = itemView.findViewById(R.id.position);
            teamNameTV = itemView.findViewById(R.id.team_name);
            matchPlayedTV = itemView.findViewById(R.id.matches_played);
            pointsTV = itemView.findViewById(R.id.points);
            goal_diff=itemView.findViewById(R.id.goalDiff);
            form= itemView.findViewById(R.id.form);
        }
    }
}
