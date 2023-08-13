package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {


    private String[][] packages= {

            {"package 1: Full body checkup" , "","","","999"},
            {"package 2: Blood Glucose Fasting" , "","","","999"},
            {"package 3: Covid 19 antibody" , "","","","999"},
            {"package 4: Thyroid Check" , "","","","999"},
            {"package 5: Immunity Check" , "","","","999"}
    };

    private String[] packages_details = {

            "Blood Glucose Fasting\n" +
                    "Complete himogram\n" +
                    "A1b3\n" +
                    "Iron Studies \n" +
                    "Kidney Fuction Test\n" +
                    "LDH Lactate Dehydrogenase Serum \n" +
                    "Lipid profile\n" +
                    "Liver Function test",
            "Blood Glucose Fasting",
            "Covid 19 antibody-IG",
            "Thyroid Profile-Total(T3 , T4& TSH ) ",
            "Complete hemogram\n"+
                    "CRP (C reactive protein ) Quatitative Serum \n" +
                    "Iron Studies\n" +
                    "Kidney Fuction Test\n" +
                    "Vitamin - D Total-25 Hydroxy\n" +
                    "Liver fuction test \n" +
                    "Lipid profile"

    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button gotocart , btnback;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        gotocart = findViewById(R.id.cartcheck);
        btnback = findViewById(R.id.ODback);
        listView = findViewById(R.id.ODlist);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost :"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent it  = new Intent(LabTestActivity.this,LabTestDetailActivity.class);

                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,cartLabActivity.class));
            }
        });


    }
}