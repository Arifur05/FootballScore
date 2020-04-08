
package com.arifur.footballscore.StatModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueStatisticsModel {

    @SerializedName("api")
    @Expose
    private Api api;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

}
