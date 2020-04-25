package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Games {

    @SerializedName("appearences")
    @Expose
    private Integer appearences;
    @SerializedName("minutes_played")
    @Expose
    private Integer minutesPlayed;

    public Integer getAppearences() {
        return appearences;
    }

    public void setAppearences(Integer appearences) {
        this.appearences=appearences;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed=minutesPlayed;
    }

}
