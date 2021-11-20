package vn.com.greenwich.estateapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList estate_id, estate_name, estate_bedroom, estate_city,
            estate_district, estate_price;


    CustomAdapter(Context context, ArrayList estate_id, ArrayList estate_name, ArrayList estate_bedroom, ArrayList estate_city,
                  ArrayList estate_district, ArrayList estate_price){
          this.context = context;
          this.estate_id = estate_id;
          this.estate_name = estate_name;
          this.estate_bedroom = estate_bedroom;
          this.estate_city = estate_city;
          this.estate_district = estate_district;
          this.estate_price = estate_price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.estate_id_txt.setText(String.valueOf(estate_id.get(position)));
        holder.estate_name_txt.setText(String.valueOf(estate_name.get(position)));
        holder.estate_bedroom_txt.setText(String.valueOf(estate_bedroom.get(position)));
        holder.estate_city_txt.setText(String.valueOf(estate_city.get(position)));
        holder.estate_district_txt.setText(String.valueOf(estate_district.get(position)));
        holder.estate_price_txt.setText(String.valueOf(estate_price.get(position)));

    }

    @Override
    public int getItemCount() {
        return estate_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView estate_id_txt, estate_name_txt, estate_bedroom_txt, estate_city_txt,
                estate_district_txt, estate_price_txt;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            estate_id_txt = itemView.findViewById(R.id.estate_id_txt);
            estate_name_txt = itemView.findViewById(R.id.estate_name_txt);
            estate_bedroom_txt = itemView.findViewById(R.id.estate_bedroom_txt);
            estate_city_txt = itemView.findViewById(R.id.estate_city_txt);
            estate_district_txt = itemView.findViewById(R.id.estate_district_txt);
            estate_price_txt = itemView.findViewById(R.id.estate_price_txt);


        }
    }
}
