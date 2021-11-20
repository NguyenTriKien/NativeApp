package vn.com.greenwich.estateapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity  {

    EditText EstateName, Street, City, District, Ward, Type, Bedroom, Price, Furniture, Reporter, Note;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EstateName = findViewById(R.id.EstateName);
        Street = findViewById(R.id.Street);
        City = findViewById(R.id.City);
        District = findViewById(R.id.District);
        Ward = findViewById(R.id.Ward);
        Type = findViewById(R.id.Type);
        Bedroom = findViewById(R.id.Bedroom);
        Price = findViewById(R.id.Price);
        Furniture = findViewById(R.id.Furniture);
        Reporter = findViewById(R.id.Reporter);
        Note = findViewById(R.id.Note);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EstateDatabase esDB = new EstateDatabase(AddActivity.this);
              if(EstateName.length()==0){
                  EstateName.setError("Enter property name");
              }else if (Street.length()==0){
                  Street.setError("Enter street");
              }else if (City.length()==0){
                  City.setError("Enter city");
              }else if (District.length()==0){
                  District.setError("Enter district");
              }else if (Ward.length()==0){
                  Ward.setError("Enter ward");
              }else if (Type.length()==0){
                  Type.setError("Enter type");
              }else if (Bedroom.length()==0){
                  Bedroom.setError("Enter bedroom");
              }else if (Price.length()==0){
                  Price.setError("Enter price");
              }else if (Reporter.length()==0){
                  Reporter.setError("Enter city");
              }else {
                  Intent intent = new Intent(AddActivity.this, Dialog.class);
                  intent.putExtra("esname",EstateName.getText().toString());
                  intent.putExtra("street", Street.getText().toString());
                  intent.putExtra("city", City.getText().toString());
                  intent.putExtra("district", District.getText().toString());
                  intent.putExtra("ward", Ward.getText().toString());
                  intent.putExtra("type", Type.getText().toString());
                  intent.putExtra("bedroom", Bedroom.getText().toString());
                  intent.putExtra("price",  Price.getText().toString());
                  intent.putExtra("furniture", Furniture.getText().toString());
                  intent.putExtra("reporter", Reporter.getText().toString());
                  intent.putExtra("note", Note.getText().toString());
                  startActivity(intent);
              }

            }
        });
    }



}