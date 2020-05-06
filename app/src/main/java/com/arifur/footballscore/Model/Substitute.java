
package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Substitute {

    @SerializedName("team_id")
    @Expose
    private Integer teamId;
    @SerializedName("player_id")
    @Expose
    private Integer playerId;
    @SerializedName("player")
    @Expose
    private String player;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("pos")
    @Expose
    private String pos;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

}
