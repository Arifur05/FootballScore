
package com.arifur.footballscore.Model.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fixture {

    @SerializedName("fixture_id")
    @Expose
    private Integer fixtureId;
    @SerializedName("league_id")
    @Expose
    private Integer leagueId;
    @SerializedName("league")
    @Expose
    private League league;
    @SerializedName("event_date")
    @Expose
    private String eventDate;
    @SerializedName("event_timestamp")
    @Expose
    private Integer eventTimestamp;
    @SerializedName("firstHalfStart")
    @Expose
    private Integer firstHalfStart;
    @SerializedName("secondHalfStart")
    @Expose
    private Integer secondHalfStart;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusShort")
    @Expose
    private String statusShort;
    @SerializedName("elapsed")
    @Expose
    private Integer elapsed;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("referee")
    @Expose
    private Object referee;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam awayTeam;
    @SerializedName("goalsHomeTeam")
    @Expose
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Integer goalsAwayTeam;
    @SerializedName("score")
    @Expose
    private Score score;

    public Integer getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Integer eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Integer getFirstHalfStart() {
        return firstHalfStart;
    }

    public void setFirstHalfStart(Integer firstHalfStart) {
        this.firstHalfStart = firstHalfStart;
    }

    public Integer getSecondHalfStart() {
        return secondHalfStart;
    }

    public void setSecondHalfStart(Integer secondHalfStart) {
        this.secondHalfStart = secondHalfStart;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusShort() {
        return statusShort;
    }

    public void setStatusShort(String statusShort) {
        this.statusShort = statusShort;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Object getReferee() {
        return referee;
    }

    public void setReferee(Object referee) {
        this.referee = referee;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
