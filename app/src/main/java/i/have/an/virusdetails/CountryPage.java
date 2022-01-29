package i.have.an.virusdetails;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPage extends AppCompatActivity {
    
    TextView updated_at;
    TextView country_name;
    TextView death_rate;
    TextView recovered_rate;
    TextView population;
    
    TextView critical;
    TextView death;
    TextView confirmed;
    
    Button totalBtn;
    Button todayBtn;
    
    Bundle extras;
    String pastValue;
    
    String todayDeath = "Death";
    String todayConfirmed = "Confirmed";
    String totalDeath = "Death";
    String totalConfirmed = "Confirmed";
    String totalCritical = "Critical";
 private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.country_details);
        
        extras = getIntent().getExtras();
        pastValue = extras.getString("country_name");
        
        settingIds();
        
        country_name.setText(pastValue);
        
        settingBtns();
        
        
        AdsLoadin();
        
        loadList();
     
    }
    
    public void settingIds(){
        country_name = findViewById(R.id.country_name);
        updated_at = findViewById(R.id.updated_at_id);
        death_rate = findViewById(R.id.death_rate_id);
        recovered_rate = findViewById(R.id.recovered_rate_id);
        population = findViewById(R.id.population_id);
        
        todayBtn = findViewById(R.id.today_btn_id);
        totalBtn = findViewById(R.id.total_btn_id);
        
        critical = findViewById(R.id.critical_id);
        death = findViewById(R.id.death_id);
        confirmed = findViewById(R.id.recovered_id);
    }
    
    public void settingBtns(){
        todayBtn.setOnClickListener(view -> {
            death.setTextColor(Color.parseColor("#f51f2f"));
            death.setText(todayDeath);
            confirmed.setTextColor(Color.parseColor("#00f100"));
           confirmed.setText(todayConfirmed);
           todayBtn.setBackgroundColor(Color.parseColor("#000000"));
           totalBtn.setBackgroundColor(Color.parseColor("#303030"));
           critical.setTextColor(Color.parseColor("#000000"));
           critical.setText(totalCritical);
        });
        totalBtn.setOnClickListener(view -> {
            death.setTextColor(Color.parseColor("#f51f2f"));
            death.setText(totalDeath);
            confirmed.setTextColor(Color.parseColor("#00f100"));
           confirmed.setText(totalConfirmed);
           totalBtn.setBackgroundColor(Color.parseColor("#000000"));
             todayBtn.setBackgroundColor(Color.parseColor("#303030"));
             critical.setTextColor(Color.parseColor("#6BB9ED"));
           critical.setText(totalCritical);
       
        });
    }
      public void loadList() {
    
        Call<Data> data = VirusClient.getServices().getDetails();
        data.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                
                Data data = response.body();
                assert data != null;
                int target=0;
               String[] names = new String[data.getCountries().size()];
                for(int i = 0; i < data.getCountries().size(); i++){
                    names[i] = data.getCountries().get(i).getName();
                    if(pastValue.equals(names[i])){
                        target=i;
                    }
                }
                updated_at.setText(("Updated on: ")+(data.getCountries().get(target).getUpdated_at()));
                population.setText(("Population: ")+(data.getCountries().get(target).getPopulation()));
                death_rate.setText(("Death Rate: ")+(data.getCountries().get(target).getLatest_data().getCalculated().getDeath_rate()));
                 recovered_rate.setText(("Recovery Rate: ")+(data.getCountries().get(target).getLatest_data().getCalculated().getRecovery_rate()));
              
                 totalCritical =("Critical :")+(data.getCountries().get(target).getLatest_data().getCritical());
                 totalConfirmed =("Confirmed :")+(data.getCountries().get(target).getLatest_data().getConfirmed());
                 totalDeath =("Death :")+(data.getCountries().get(target).getLatest_data().getDeaths());
                  todayDeath =("Death :")+(data.getCountries().get(target).getToday().getDeaths());
                 todayConfirmed =("Confirmed :")+(data.getCountries().get(target).getToday().getConfirmed());
                 }
    
            @Override
            public void onFailure(@NonNull Call<Data> call,@NonNull Throwable t) {
                Toast.makeText(CountryPage.this,"sorry",Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void AdsLoadin(){
         MobileAds.initialize(this, initializationStatus -> {});
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView adView = new AdView(this);
        mAdView = findViewById(R.id.adView);
        mAdView.loadAd(adRequest);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2728254994856043/4457723402");
    }
}
