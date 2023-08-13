package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edPassword , edEmail , edconfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edUsername = findViewById(R.id.bookfullname);
        edPassword = findViewById(R.id.bookpincode);
        edEmail = findViewById(R.id.bookaddress);
        edconfirm = findViewById(R.id.bookcontact);
        btn = findViewById(R.id.buttonlabtestbooking);
        tv = findViewById(R.id.textViewExistinguser);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edconfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);



                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {

                    if (password.compareTo(confirm) == 0) {
                            if(isValid(password))
                            {
                                db.register(username,email,password);
                                Toast.makeText(getApplicationContext(), "Record inserted ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Password must contain 8 character ", Toast.LENGTH_SHORT).show();
                            }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
        public static boolean isValid(String passwordhere)
        {
            int f1 =0 , f2=0 , f3=0;

            if(passwordhere.length()<8)
            {
                return false;
            }else{

                for(int i=0;i<passwordhere.length();i++)
                {
                    if(Character.isLetter(passwordhere.charAt(i))){
                        f1 =1;
                    }
                }
                for(int j=0;j<passwordhere.length();j++)
                {
                    if(Character.isDigit(passwordhere.charAt(j))){
                        f2 =1;
                    }
                }
                for(int k=0;k<passwordhere.length();k++)
                {
                    char c = passwordhere.charAt(k);
                    if(c>=33 && c<=46 || c==64){
                        f3 =1;
                    }
                }

                if(f1==1 && f2==1 && f3==1)
                {
                    return true;
                }
                return false;
            }
        }

}