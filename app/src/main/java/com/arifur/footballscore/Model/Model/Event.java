
package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("elapsed")
    @Expose
    private Integer elapsed;
    @SerializedName("elapsed_plus")
    @Expose
    private Object elapsedPlus;
    @SerializedName("team_id")
    @Expose
    private Integer teamId;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("player_id")
    @Expose
    private Integer playerId;
    @SerializedName("player")
    @Expose
    private String player;
    @SerializedName("assist_id")
    @Expose
    private Integer assistId;
    @SerializedName("assist")
    @Expose
    private String assist;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("comments")
    @Expose
    private Object comments;

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Object getElapsedPlus() {
        return elapsedPlus;
    }

    public void setElapsedPlus(Object elapsedPlus) {
        this.elapsedPlus = elapsedPlus;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getAssistId() {
        return assistId;
    }

    public void setAssistId(Integer assistId) {
        this.assistId = assistId;
    }

    public String getAssist() {
        return assist;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

}
