package com.arifur.footballscore.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Model.Fixtures.Fixture;
import com.arifur.footballscore.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class LiveFixtureAdapter extends RecyclerView.Adapter<LiveFixtureAdapter.LiveFixtureViewHolder> {
    private Context context;
    private List<Fixture> fixtureLists;

    public LiveFixtureAdapter(Context context, List<Fixture> fixtureLists) {
        this.context = context;
        this.fixtureLists = fixtureLists;
    }

    @NonNull
    @Override
    public LiveFixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.match_in_fixture, parent, false);

        return new LiveFixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveFixtureViewHolder holder, int position) {
        Fixture fixture = fixtureLists.get(position);
        if (fixtureLists!=null) {
          try {
            holder.time.setText(fixture.getEventDate());
            holder.homeScore.setText(fixture.getGoalsHomeTeam().toString());
            holder.awayScore.setText(fixture.getGoalsAwayTeam().toString());
            try {
                Glide.with(context)
                        .load(fixture.getAwayTeam().getLogo())
                        .centerCrop()
                        .into(holder.homeTeam);
                Glide.with(context)
                        .load(fixture.getHomeTeam().getLogo())
                        .centerCrop()
                        .into(holder.awayTeam);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
          }
          catch (Exception e){
              e.printStackTrace();
          }
        }
        else {
            holder.time.setText("time");
            holder.homeScore.setText("-");
            holder.awayScore.setText("-");
            Glide.with(context)
                    .load(R.drawable.ic_verified_user_black_24dp)
                    .centerCrop()
                    .into(holder.homeTeam);
            Glide.with(context)
                    .load(R.drawable.ic_verified_user_black_24dp)
                    .centerCrop()
                    .into(holder.awayTeam);
            holder.status.setVisibility(View.VISIBLE);
            holder.status.setText("Currently no fixtures in play");
        }
    }

    @Override
    public int getItemCount() {
        return fixtureLists.size();
    }


    public static class LiveFixtureViewHolder extends RecyclerView.ViewHolder {

        ImageView homeTeam, awayTeam;
         TextView homeScore, awayScore,time,status;
        LinearLayout scorelayout;
        public LiveFixtureViewHolder(@NonNull View itemView) {

            super(itemView);
            homeTeam = (ImageView) itemView.findViewById(R.id.home_Teams);
            awayTeam = itemView.findViewById(R.id.away_Teams);
            homeScore = itemView.findViewById(R.id.home_Scores);
            time=itemView.findViewById(R.id.time);
            awayScore = itemView.findViewById(R.id.away_Scores);
            status=itemView.findViewById(R.id.status);
            scorelayout=itemView.findViewById(R.id.scoreLayout);
        }
    }
}
