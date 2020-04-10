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
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NextFixtureAdapter extends RecyclerView.Adapter<NextFixtureAdapter.ScoreViewHolder> {
    private Context context;
    private List<Fixture> fixtureList=new ArrayList<>();


    public NextFixtureAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
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

        Fixture fixture = fixtureList.get(position);
        try {
            String url=fixture.getHomeTeam().getLogo();
            String url1= fixture.getAwayTeam().getLogo();
            Glide.with(context).load(url).into(holder.hometeam);
            Glide.with(context).load(url1).into(holder.awayteam);
            holder.versus.setText("Versus");
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {


        private TextView versus;
        private ImageView hometeam, awayteam;

        public  ScoreViewHolder(@NonNull View itemView) {

            super(itemView);
            versus = (TextView) itemView.findViewById(R.id.versus);
            hometeam = itemView.findViewById(R.id.home_Team);
            awayteam = itemView.findViewById(R.id.away_Team);
        }
    }
}
