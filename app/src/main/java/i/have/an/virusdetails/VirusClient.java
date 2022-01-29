package i.have.an.virusdetails;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class VirusClient {
    
    public static final String URL = "https://corona-api.com/";
    
    public static Services virusDetail = null;
    
    public static Services getServices(){
        if(virusDetail == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
            virusDetail = retrofit.create(Services.class);
        }
        return virusDetail;
    }
    public interface Services{
    @GET("countries")
    Call<Data> getDetails();
    }
}
