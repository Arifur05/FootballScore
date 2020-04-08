
package com.arifur.footballscore.Model.Fixtures;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
