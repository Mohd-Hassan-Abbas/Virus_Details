package i.have.an.virusdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    RecyclerView recyclerview;
    String[] names={};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
       recyclerview = findViewById(R.id.countriesList);
        
       loadList();
       
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new CountryAdapter(names));
    }
    
    public void loadList() {
    
        Call<Data> data = VirusClient.getServices().getDetails();
        data.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                
                Data data = response.body();
                assert data != null;
                names = new String[data.getCountries().size()];
                for(int i = 0; i < data.getCountries().size(); i++){
                    names[i] = data.getCountries().get(i).getName();
                }
                  recyclerview.setAdapter(new CountryAdapter(names));
  
                 }
    
            @Override
            public void onFailure(@NonNull Call<Data> call,@NonNull Throwable t) {
                Toast.makeText(MainActivity.this,"sorry",Toast.LENGTH_SHORT).show();
            }
        });
    }
}