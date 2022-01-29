package i.have.an.virusdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {
    
    @SerializedName("name")
    @Expose
    String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public int getPopulation() {
        return population;
    }
    
    public void setPopulation(int population) {
        this.population = population;
    }
    
    public String getUpdated_at() {
        return updated_at;
    }
    
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    public Today getToday() {
        return today;
    }
    
    public void setToday(Today today) {
        this.today = today;
    }
    
    public LatestData getLatest_data() {
        return latest_data;
    }
    
    public void setLatest_data(LatestData latest_data) {
        this.latest_data = latest_data;
    }
    
    @SerializedName("code")
    @Expose
    String code;
    
    @SerializedName("population")
    @Expose
    int population;
    
    @SerializedName("updated_at")
    @Expose
    String updated_at;
    
    @SerializedName("today")
    @Expose
    Today today ;
    
    @SerializedName("latest_data")
    @Expose
    LatestData latest_data;
}
    