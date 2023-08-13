package com.example.doctorbhai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MedicineListActivity extends AppCompatActivity {


    int[] images= {
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex,
            R.drawable.furex

    };

    MyAdapter myAdapter;

    private SearchView searchView;

    String [] title ,desc;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);

        searchView = findViewById(R.id.searchviewid);
        searchView.clearFocus();

        recyclerView = findViewById(R.id.recyclerid);
        title = getResources().getStringArray(R.array.medicine_name);
        desc = getResources().getStringArray(R.array.medicine_descrip);

        myAdapter = new MyAdapter(this,title,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });

    }


}