package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);


        CardView familyhysician = findViewById(R.id.cardFD_physician);

        familyhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);

            }
        });

        CardView dietician = findViewById(R.id.cardFD_diet);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);

            }
        });

        CardView dentist = findViewById(R.id.cardFD_Dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });

        CardView surgeon = findViewById(R.id.cardFD_Surgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);

            }
        });

        CardView cardiologist = findViewById(R.id.cardFD_cardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it  = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);

            }
        });





    }

}