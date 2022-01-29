package i.have.an.virusdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestData {
    @SerializedName("deaths")
    @Expose
    int deaths;
    
    public int getDeaths() {
        return deaths;
    }
    
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    
    public int getConfirmed() {
        return confirmed;
    }
    
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }
    
    public int getRecovered() {
        return recovered;
    }
    
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
    
    public int getCritical() {
        return critical;
    }
    
    public void setCritical(int critical) {
        this.critical = critical;
    }
    
    public Calculated getCalculated() {
        return calculated;
    }
    
    public void setCalculated(Calculated calculated) {
        this.calculated = calculated;
    }
    
    @SerializedName("confirmed")
    @Expose()
    int confirmed;
    
    @SerializedName("recovered")
    @Expose
    int recovered;
    
    @SerializedName("critical")
    @Expose
    int critical;
    
    @SerializedName("calculated")
    @Expose
    Calculated calculated;
    
}
