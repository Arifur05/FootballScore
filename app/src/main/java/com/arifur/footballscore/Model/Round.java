
package com.arifur.footballscore.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Round {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("matches")
    @Expose
    private List<Match> matches;

    public Round(String name, List<Match> matches) {
        this.name = name;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

}
