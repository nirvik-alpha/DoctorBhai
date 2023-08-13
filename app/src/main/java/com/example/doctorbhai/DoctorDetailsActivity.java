package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {

            {"Doctor : AAA" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : BBB" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : CCC" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : DDD" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : EEE" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"}

    };

    private String[][] doctor_details2 = {

            {"Doctor : FFF" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : GGG" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : HHH" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : III" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : JJJ" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"}

    };

    private String[][] doctor_details3 = {

            {"Doctor : K" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : L" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : M" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : N" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : O" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"}

    };

    private String[][] doctor_details4 = {

            {"Doctor : P" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : Q" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : R" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : S" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : T" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"}

    };

    private String[][] doctor_details5 = {

            {"Doctor : U" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : V" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : W" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : X" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"},
            {"Doctor : Y" , "Hospital :Dhanmonid " , "Exp: 5 years" , "Contact:3532525" , "500Tk"}

    };



    TextView tv;
    Button btn ;
    String[][] doctor_details={};
    HashMap<String,String>item;

    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.ODdet);
        btn = findViewById(R.id.ODback);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if(title.compareTo("Family Physician")==0)
        {
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietician")==0)
        {
            doctor_details = doctor_details2;
        }
        else if(title.compareTo("Surgeon")==0)
        {
            doctor_details = doctor_details3;
        }
       else if(title.compareTo("Dentist")==0)
        {
            doctor_details = doctor_details4;
        }
       else
        {
            doctor_details = doctor_details5;
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

       list = new ArrayList();
       for(int i=0;i<doctor_details.length;i++)
       {
           item = new HashMap<String,String>();
           item.put("line1",doctor_details[i][0]);
           item.put("line2",doctor_details[i][1]);
           item.put("line3",doctor_details[i][2]);
           item.put("line4",doctor_details[i][3]);
           item.put("line5","Cons fee :"+doctor_details[i][4]+"/-");
            list.add(item);
       }

       sa = new SimpleAdapter(this,list,
               R.layout.multi_lines,
               new String[]{"line1","line2","line3","line4","line5"},
               new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
       );

        ListView lst = findViewById(R.id.ODlist);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it  = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);

                startActivity(it);
            }
        });



    }
}