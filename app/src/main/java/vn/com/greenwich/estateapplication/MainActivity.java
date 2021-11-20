package vn.com.greenwich.estateapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    EstateDatabase esDB;
    ArrayList<String> estate_id, estate_street,estate_name, estate_bedroom, estate_city,
    estate_district, estate_price;
    CustomAdapter customAdapter;

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, AddActivity.class);
               startActivity(intent);
               //finish();
            }
        });

        esDB = new EstateDatabase(MainActivity.this);
        estate_id = new ArrayList<>();
        estate_name = new ArrayList<>();
        estate_bedroom = new ArrayList<>();
        estate_city = new ArrayList<>();
        estate_district = new ArrayList<>();
        estate_price = new ArrayList<>();

        storeData();
        customAdapter = new CustomAdapter(MainActivity.this, estate_id, estate_name, estate_bedroom, estate_city, estate_district, estate_price);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    void storeData(){
        Cursor cursor = esDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                estate_id.add(cursor.getString(0));
                estate_name.add(cursor.getString(1));
                estate_bedroom.add(cursor.getString(7));
                estate_city.add(cursor.getString(3));
                estate_district.add(cursor.getString(4));
                estate_price.add(cursor.getString(8));
            }
        }

    }
}