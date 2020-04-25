
package com.arifur.footballscore.Model.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParisSaintGermain {

    @SerializedName("coach_id")
    @Expose
    private Integer coachId;
    @SerializedName("coach")
    @Expose
    private String coach;
    @SerializedName("formation")
    @Expose
    private String formation;
    @SerializedName("startXI")
    @Expose
    private List<StartXI_> startXI = null;
    @SerializedName("substitutes")
    @Expose
    private List<Substitute_> substitutes = null;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public List<StartXI_> getStartXI() {
        return startXI;
    }

    public void setStartXI(List<StartXI_> startXI) {
        this.startXI = startXI;
    }

    public List<Substitute_> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<Substitute_> substitutes) {
        this.substitutes = substitutes;
    }

}
