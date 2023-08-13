package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome user",Toast.LENGTH_SHORT).show();

        CardView emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,EmergencyActivity.class));
            }
        });

        ///////////////////////////////////////////////////////////////////////////
        CardView finddoctor = findViewById(R.id.cardfind_doctor);
        finddoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class));
            }
        });
        ///////////////////////////////////////////////////////////////////////
        CardView labtest = findViewById(R.id.labtest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
            }
        });

        ///////////////////////////////////////////////////////////////////////////
        CardView healtharticle = findViewById(R.id.cardHealthDoctor);
        healtharticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ArticleActivity.class));
            }
        });

        ///////////////////////////////////////////////////////////
        CardView buymed = findViewById(R.id.buy_medicine);
        buymed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MedicineListActivity.class));
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        CardView orderdet = findViewById(R.id.orderDetails);
        orderdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,OrderDetailsActivity.class));
            }
        });
        /////////////////////////////////////////////////////////////////////////
        CardView bmical = findViewById(R.id.bmicalc);
        bmical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,BMIActivity.class));
            }
        });
        ////////////////////////////////////////////////////////////////////////
        CardView videohome = findViewById(R.id.videohome);

        videohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HealthVideoActivity.class));
            }
        });

    }
}