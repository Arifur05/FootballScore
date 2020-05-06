
package com.arifur.footballscore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineUps {

    @SerializedName("Stade Brestois 29")
    @Expose
    private StadeBrestois29 stadeBrestois29;
    @SerializedName("Paris Saint Germain")
    @Expose
    private ParisSaintGermain parisSaintGermain;

    public StadeBrestois29 getStadeBrestois29() {
        return stadeBrestois29;
    }

    public void setStadeBrestois29(StadeBrestois29 stadeBrestois29) {
        this.stadeBrestois29 = stadeBrestois29;
    }

    public ParisSaintGermain getParisSaintGermain() {
        return parisSaintGermain;
    }

    public void setParisSaintGermain(ParisSaintGermain parisSaintGermain) {
        this.parisSaintGermain = parisSaintGermain;
    }

}
