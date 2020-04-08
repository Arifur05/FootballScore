package com.arifur.footballscore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.arifur.footballscore.Fragments.MatchSchedule;
import com.arifur.footballscore.Fragments.News;
import com.arifur.footballscore.Fragments.Statistics;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LeagueName extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.action_news:
                    News newsFragmentTransaction = new News();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.container, newsFragmentTransaction, "");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.action_schedule:
                    MatchSchedule matchSceduleTransaction = new MatchSchedule();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, matchSceduleTransaction, "");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.action_stat:
                    Statistics statisticsTransaction = new Statistics();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.container, statisticsTransaction, "");
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_name);

        BottomNavigationView footballscoreNavView = findViewById(R.id.footballscoreNavView);
        footballscoreNavView.setOnNavigationItemSelectedListener(selectedListener);

        News newsFragmentTransaction = new News();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.container, newsFragmentTransaction, "");
        fragmentTransaction1.commit();

    }

}
