
package com.arifur.footballscore.Model.StatModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("standings")
    @Expose
    private List<List<Standing>> standings= null;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(List<List<Standing>> standings) {
        this.standings = standings;
    }

}
