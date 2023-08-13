package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class cartLabActivity extends AppCompatActivity {

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;

    TextView tvtotal;
    private Button datebtn ,timebtn, btcheck ,btnback;
    private String[] packages[]= {};

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        datebtn = findViewById(R.id.buttoncartdate);
        timebtn = findViewById(R.id.buttoncarttime);

        btnback =findViewById(R.id.ODback);
        btcheck = findViewById(R.id.cartcheck);

        tvtotal = findViewById(R.id.carttotcost);


        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        Database db = new Database(getApplicationContext(),"healthcare",null,1);

        float totalamount=0;
        ArrayList dbdata = db.getCartdata(username,"lab");

        packages = new String[dbdata.size()][];
        for(int i=0;i<packages.length;i++){
            packages[i] = new String[5];
        }

        for(int i=0;i<dbdata.size();i++)
        {
            String arrData = dbdata.get(i).toString();
            String[] strdata = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strdata[0];
            packages[i][4] = "Cost:"+strdata[1]+"/-";
            totalamount = totalamount + Float.parseFloat(strdata[1]);
        }

        tvtotal.setText("Total Cost:"+totalamount);
        list = new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst = findViewById(R.id.ODlist);
        lst.setAdapter(sa);


         btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cartLabActivity.this,LabTestActivity.class));
            }
        });
        btcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(cartLabActivity.this,LabTestBookAcitivity.class);
                it.putExtra("price",tvtotal.getText());
                it.putExtra("date",datebtn.getText());
                it.putExtra("time",timebtn.getText());

                startActivity(it);

            }
        });

        initDatePicker();
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        initTimePicker();
        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                datebtn.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal =Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);

    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timebtn.setText(i+"/"+i1);
            }
        };
        Calendar cal =Calendar.getInstance();
        int hr = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);


        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hr,mins,true);




    }

}