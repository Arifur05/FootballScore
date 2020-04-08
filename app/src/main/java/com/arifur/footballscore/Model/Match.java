
package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("team1")
    @Expose
    private Team1 team1;
    @SerializedName("team2")
    @Expose
    private Team2 team2;
    @SerializedName("score1")
    @Expose
    private Integer score1;
    @SerializedName("score2")
    @Expose
    private Integer score2;

    public Match(String date, Team1 team1, Team2 team2, Integer score1, Integer score2) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team1 getTeam1() {
        return team1;
    }

    public void setTeam1(Team1 team1) {
        this.team1 = team1;
    }

    public Team2 getTeam2() {
        return team2;
    }

    public void setTeam2(Team2 team2) {
        this.team2 = team2;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

}
