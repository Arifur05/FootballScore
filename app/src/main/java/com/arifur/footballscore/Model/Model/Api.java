package com.arifur.footballscore.Model.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Api {

    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("standings")
    @Expose
    private List<List<Standing>> standings=null;
    @SerializedName("topscorers")
    @Expose
    private List<Topscorer> topscorers=null;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures=null;
    @SerializedName("teams")
    @Expose
    private List<Teams> teams=null;

    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("lineUps")
    @Expose
    private LineUps lineUps;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results=results;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(List<List<Standing>> standings) {
        this.standings=standings;
    }

    public List<Topscorer> getTopscorers() {
        return topscorers;
    }

    public void setTopscorers(List<Topscorer> topscorers) {
        this.topscorers=topscorers;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures=fixtures;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> teams) {
        this.teams=teams;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events=events;
    }

    public LineUps getLineUps() {
        return lineUps;
    }

    public void setLineUps(LineUps lineUps) {
        this.lineUps=lineUps;
    }
}
