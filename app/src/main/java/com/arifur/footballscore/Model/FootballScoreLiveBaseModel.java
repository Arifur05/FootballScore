package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FootballScoreLiveBaseModel {

    @SerializedName("api")
    @Expose
    private Api api;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api=api;
    }

}
