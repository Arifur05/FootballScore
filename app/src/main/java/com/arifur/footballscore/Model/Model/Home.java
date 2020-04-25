package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Home {

    @SerializedName("matchsPlayed")
    @Expose
    private Integer matchsPlayed;
    @SerializedName("win")
    @Expose
    private Integer win;
    @SerializedName("draw")
    @Expose
    private Integer draw;
    @SerializedName("lose")
    @Expose
    private Integer lose;
    @SerializedName("goalsFor")
    @Expose
    private Integer goalsFor;
    @SerializedName("goalsAgainst")
    @Expose
    private Integer goalsAgainst;

    public Integer getMatchsPlayed() {
        return matchsPlayed;
    }

    public void setMatchsPlayed(Integer matchsPlayed) {
        this.matchsPlayed=matchsPlayed;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win=win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw=draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose=lose;
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(Integer goalsFor) {
        this.goalsFor=goalsFor;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst=goalsAgainst;
    }

}
