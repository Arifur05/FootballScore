
package com.arifur.footballscore.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueScoreModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rounds")
    @Expose
    private List<Round> rounds = null;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }


}
