package vn.com.greenwich.estateapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class Dialog extends AppCompatActivity {
    private String name;
    private EditText EstateName2, Street2, City2, District2, Ward2, Type2, Bedroom2, Price2,
            Furniture2, Reporter2, Note2;
    Button confirm;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dialog);

        EstateName2 = findViewById(R.id.EstateName2);
        Street2 = findViewById(R.id.Street2);
        City2 = findViewById(R.id.City2);
        District2 = findViewById(R.id.District2);
        Ward2= findViewById(R.id.Ward2);
        Type2 = findViewById(R.id.Type2);
        Bedroom2 = findViewById(R.id.Bedroom2);
        Price2 = findViewById(R.id.Price2);
        Furniture2 = findViewById(R.id.Furniture2);
        Reporter2 = findViewById(R.id.Reporter2);
        Note2 = findViewById(R.id.Note2);
        confirm = findViewById(R.id.confirm);

        EstateName2.setText(getIntent().getStringExtra("esname"));
        Street2.setText(getIntent().getStringExtra("street"));
        City2.setText(getIntent().getStringExtra("city"));
        District2.setText(getIntent().getStringExtra("district"));
        Ward2.setText(getIntent().getStringExtra("ward"));
        Type2.setText(getIntent().getStringExtra("type"));
        Bedroom2.setText(getIntent().getStringExtra("bedroom"));
        Price2.setText(getIntent().getStringExtra("price"));
        Furniture2.setText(getIntent().getStringExtra("furniture"));
        Reporter2.setText(getIntent().getStringExtra("reporter"));
        Note2.setText(getIntent().getStringExtra("note"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EstateDatabase esDB = new EstateDatabase(Dialog.this);
                esDB.addEstate(
                          EstateName2.getText().toString().trim(),
                          Street2.getText().toString().trim(),
                          City2.getText().toString().trim(),
                          District2.getText().toString().trim(),
                          Ward2.getText().toString().trim(),
                          Type2.getText().toString().trim(),
                          Integer.parseInt(Bedroom2.getText().toString().trim()),
                          Float.parseFloat(Price2.getText().toString().trim()),
                          Furniture2.getText().toString().trim(),
                          Reporter2.getText().toString().trim(),
                          Note2.getText().toString().trim());


            }
        });

    }
}
