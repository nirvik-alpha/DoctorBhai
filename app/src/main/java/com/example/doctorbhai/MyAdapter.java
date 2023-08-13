package com.example.doctorbhai;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context context;
    String[] title ,desc;
    int[] images ;

    public MyAdapter(Context context, String[] title, String[] desc, int[] images) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.titletextView.setText(title[position]);
        holder.descview.setText(desc[position]);
        holder.imgview.setImageResource(images[position]);



    }

    @Override
    public int getItemCount() {
        return title.length;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titletextView , descview;
        ImageView imgview;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titletextView = itemView.findViewById(R.id.mediname);
            descview = itemView.findViewById(R.id.mediamount);
            imgview = itemView.findViewById(R.id.medicineimages);



        }
    }

}
