package i.have.an.virusdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Calculated {
    public float getDeath_rate() {
        return death_rate;
    }
    
    public void setDeath_rate(float death_rate) {
        this.death_rate = death_rate;
    }
    
    public float getRecovery_rate() {
        return recovery_rate;
    }
    
    public void setRecovery_rate(float recovery_rate) {
        this.recovery_rate = recovery_rate;
    }
    
    @SerializedName("death_rate")
    @Expose
    float death_rate;
    
    @SerializedName("recovery_rate")
    @Expose
    float recovery_rate;
    
}
