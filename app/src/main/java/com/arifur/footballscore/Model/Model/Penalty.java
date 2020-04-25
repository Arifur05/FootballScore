package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Penalty {

    @SerializedName("won")
    @Expose
    private Integer won;
    @SerializedName("commited")
    @Expose
    private Object commited;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("missed")
    @Expose
    private Integer missed;
    @SerializedName("saved")
    @Expose
    private Object saved;

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won=won;
    }

    public Object getCommited() {
        return commited;
    }

    public void setCommited(Object commited) {
        this.commited=commited;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success=success;
    }

    public Integer getMissed() {
        return missed;
    }

    public void setMissed(Integer missed) {
        this.missed=missed;
    }

    public Object getSaved() {
        return saved;
    }

    public void setSaved(Object saved) {
        this.saved=saved;
    }

}
