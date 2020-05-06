package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cards {

    @SerializedName("yellow")
    @Expose
    private Integer yellow;
    @SerializedName("second_yellow")
    @Expose
    private Integer secondYellow;
    @SerializedName("red")
    @Expose
    private Integer red;

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow=yellow;
    }

    public Integer getSecondYellow() {
        return secondYellow;
    }

    public void setSecondYellow(Integer secondYellow) {
        this.secondYellow=secondYellow;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red=red;
    }

}
