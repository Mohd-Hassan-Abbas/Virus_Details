package i.have.an.virusdetails;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    
    String[] names;
    
    public CountryAdapter(String[] names){
        this.names=names;
    }
    
    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.countries_name,parent,false);
        return new CountryViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        String str = names[position];
        holder.name.setText(str);
    }
    
    @Override
    public int getItemCount() {
        return names.length;
    }
    
    public static class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public CountryViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.CountryItem);
            itemView.setOnClickListener(view->{
            Intent intent = new Intent(itemView.getContext(),CountryPage.class);
            intent.putExtra("country_name",name.getText().toString());
            itemView.getContext().startActivity(intent);
            });
        }
    }
}
