package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goals {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("assists")
    @Expose
    private Integer assists;
    @SerializedName("conceded")
    @Expose
    private Object conceded;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total=total;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists=assists;
    }

    public Object getConceded() {
        return conceded;
    }

    public void setConceded(Object conceded) {
        this.conceded=conceded;
    }

}
