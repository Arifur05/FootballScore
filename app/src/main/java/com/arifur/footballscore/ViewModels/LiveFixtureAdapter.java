package com.arifur.footballscore.ViewModels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arifur.footballscore.Api.ScoreApi;
import com.arifur.footballscore.Model.Api;
import com.arifur.footballscore.Model.Fixture;
import com.arifur.footballscore.Model.FootballScoreLiveBaseModel;
import com.arifur.footballscore.R;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveFixtureAdapter extends RecyclerView.Adapter<LiveFixtureAdapter.LiveFixtureViewHolder> {
    private Context context;
    private List<Fixture> fixtureLists;

    String mfixture_id;

    public LiveFixtureAdapter(Context context, List<Fixture> fixtureLists) {
        this.context=context;
        this.fixtureLists=fixtureLists;
    }

    @NonNull
    @Override
    public LiveFixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.match_in_fixture, parent, false);

        return new LiveFixtureViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LiveFixtureViewHolder holder, int position) {

        if (fixtureLists != null) {
            mfixture_id=fixtureLists.get(position).getFixtureId().toString();
            getEvents();
            try {
                holder.time.setText(fixtureLists.get(position).getEventDate());
                holder.homeScore.setText(fixtureLists.get(position).getGoalsHomeTeam().toString());
                holder.awayScore.setText(fixtureLists.get(position).getGoalsAwayTeam().toString());

                Glide.with(context)
                        .load(fixtureLists.get(position).getAwayTeam().getLogo())
                        .centerCrop()
                        .into(holder.homeTeam);
                Glide.with(context)
                        .load(fixtureLists.get(position).getHomeTeam().getLogo())
                        .centerCrop()
                        .into(holder.awayTeam);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
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
        holder.setIsRecyclable(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return fixtureLists.size();
    }


    public static class LiveFixtureViewHolder extends RecyclerView.ViewHolder {

        ImageView homeTeam, awayTeam;
        TextView homeScore, awayScore, time, status;
        LinearLayout scorelayout;

        public LiveFixtureViewHolder(@NonNull View itemView) {

            super(itemView);
            homeTeam=(ImageView) itemView.findViewById(R.id.home_Teams);
            awayTeam=itemView.findViewById(R.id.away_Teams);
            homeScore=itemView.findViewById(R.id.home_Scores);
            time=itemView.findViewById(R.id.time);
            awayScore=itemView.findViewById(R.id.away_Scores);

            scorelayout=itemView.findViewById(R.id.scoreLayout);
        }
    }
    private void  getEvents(){
        Call<FootballScoreLiveBaseModel> eventsList=ScoreApi.getFixtureInPlay().getEvents(mfixture_id);
        eventsList.enqueue(new Callback<FootballScoreLiveBaseModel>() {
            @Override
            public void onResponse(Call<FootballScoreLiveBaseModel> call, Response<FootballScoreLiveBaseModel> response) {
                FootballScoreLiveBaseModel footballScoreLiveBaseModel=response.body();
                Api api= footballScoreLiveBaseModel.getApi();

            }

            @Override
            public void onFailure(Call<FootballScoreLiveBaseModel> call, Throwable t) {

            }
        });
    }
}
