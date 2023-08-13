package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailActivity extends AppCompatActivity {


    TextView tcost ,tpackage;
    EditText editmulti;

    Button btnadd ,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);


        tcost = findViewById(R.id.ttcost);
        tpackage = findViewById(R.id.labpackages);
        editmulti = findViewById(R.id.editTextTextMultiLine2);
        btnback = findViewById(R.id.btnlabdet);
        btnadd = findViewById(R.id.btnadd);


        editmulti.setKeyListener(null);

        Intent intent =  getIntent();
        tpackage.setText(intent.getStringExtra("text1"));
        editmulti.setText(intent.getStringExtra("text2"));
        tcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tpackage.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                if(db.checkCart(username,product)==1)
                {
                    Toast.makeText(getApplicationContext(),"Product Already Added",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Record Inserted to cart",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
                }


            }
        });


    }
}