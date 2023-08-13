package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookAcitivity extends AppCompatActivity {

    EditText edname, edaddress,edcontact, edpincode;
    Button btnlabbooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book_acitivity);

        edname = findViewById(R.id.bookfullname);
        edaddress = findViewById(R.id.bookaddress);
        edcontact = findViewById(R.id.bookcontact);
        edpincode = findViewById(R.id.bookpincode);
        btnlabbooking = findViewById(R.id.buttonlabtestbooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnlabbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(getApplicationContext(),"Your Booking is done successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookAcitivity.this,HomeActivity.class));

            }
        });


    }
}