package i.have.an.virusdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Today {
    
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
    
    @SerializedName("deaths")
    @Expose
    int deaths;
    
    
    @SerializedName("confirmed")
    @Expose
    int confirmed;
    
}
