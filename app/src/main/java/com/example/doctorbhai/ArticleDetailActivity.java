package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleDetailActivity extends AppCompatActivity {

    TextView txt;
    ImageView img;
    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        btnback = findViewById(R.id.detailbtnback);
        txt  = findViewById(R.id.textarticledetail);
        img = findViewById(R.id.articleimagedetail);

        Intent intent = new Intent();

        txt.setText(intent.getStringExtra("text1"));
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            int resid = bundle.getInt("text2");
            img.setImageResource(resid);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArticleDetailActivity.this,ArticleActivity.class));
            }
        });


    }
}