package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.Teams;
import com.arifur.footballscore.Model.Topscorer;
import com.arifur.footballscore.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopScorerAdapter extends RecyclerView.Adapter<TopScorerAdapter.TopScorerViewHolder> {
    Context context;
    List<Topscorer> topscorerList;
    List<Teams> teamsList;

    String playerTeamName;

    public TopScorerAdapter(Context context, List<Topscorer> topscorerList, List<Teams> teamsList) {
        this.context=context;
        this.topscorerList=topscorerList;
        this.teamsList=teamsList;
    }


    @NonNull
    @Override
    public TopScorerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.top_scorer_card, parent, false);
        return new TopScorerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopScorerViewHolder holder, int position) {

        try {
            String pos=String.valueOf(position + 2);
            holder.playerPos.setText(pos);
            holder.playerName.setText(topscorerList.get(position).getPlayerName());
            holder.playerGoalNumber.setText(topscorerList.get(position).getGoals().getTotal().toString());
            playerTeamName=topscorerList.get(position).getTeamName();
            if (teamsList != null) {
                for (int i=0; i < teamsList.size(); i++) {
                    String teamName=teamsList.get(i).getName();
                    if (playerTeamName.equals(teamName)) {
                        Picasso.get().load(teamsList.get(i).getLogo()).resize(50, 50).centerCrop().into(holder.playerTeamLogo);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return topscorerList.size();
    }

    public class TopScorerViewHolder extends RecyclerView.ViewHolder {
        TextView playerName, playerPos, playerGoalNumber;
        ImageView playerTeamLogo;

        public TopScorerViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName=itemView.findViewById(R.id.scorer_name);
            playerPos=itemView.findViewById(R.id.position_of_scorer);
            playerGoalNumber=itemView.findViewById(R.id.scorers_total_score);
            playerTeamLogo=itemView.findViewById(R.id.scorers_tean_logo);
        }
    }
}
