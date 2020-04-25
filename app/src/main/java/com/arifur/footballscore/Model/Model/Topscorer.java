package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topscorer {

    @SerializedName("player_id")
    @Expose
    private Integer playerId;
    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("team_id")
    @Expose
    private Integer teamId;
    @SerializedName("team_name")
    @Expose
    private String teamName;
    @SerializedName("games")
    @Expose
    private Games games;
    @SerializedName("goals")
    @Expose
    private Goals goals;
    @SerializedName("shots")
    @Expose
    private Shots shots;
    @SerializedName("penalty")
    @Expose
    private Penalty penalty;
    @SerializedName("cards")
    @Expose
    private Cards cards;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId=playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName=playerName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname=firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname=lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position=position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality=nationality;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId=teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName=teamName;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games=games;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals=goals;
    }

    public Shots getShots() {
        return shots;
    }

    public void setShots(Shots shots) {
        this.shots=shots;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty=penalty;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards=cards;
    }

}
