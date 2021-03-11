package com.example.zubayer.weatherapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import retrofit2.http.Url;

/**
 * Created by Zubayer on 5/31/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<Example> tepmArray;

    public RecyclerAdapter(Context context, ArrayList<Example> tepmArray) {
        this.context = context;
        this.tepmArray = tepmArray;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {


      //  Calendar date=Calendar.getInstance();
      //  date.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
      // date.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE dd-MMM-yyyy");

       // Date d=new Date();
        Calendar calendar=Calendar.getInstance();


        for(int i=position;i<=position;i++){
           calendar.add(Calendar.DAY_OF_WEEK,i);

        }
       // Date dayW=calendar.getTime();
      String date=simpleDateFormat.format(calendar.getTime());

       // String weekDay1=calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
      //  holder.dayText1.setText(new StringBuilder().append(weekDay1));

        holder.dayText1.setText(date);




        holder.textView.setText(tepmArray.get(position).getList().get(position).getTemp().getDay()+"°c");

        Picasso.with(context).load("http://openweathermap.org/img/w/"+tepmArray.get(position).getList()
                .get(position).getWeather().get(0).getIcon()+".png").resize(110,100).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return tepmArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView textView,dayText1;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            dayText1=itemView.findViewById(R.id.Day1);
            textView=itemView.findViewById(R.id.dayTemp);
            imageView=itemView.findViewById(R.id.icon2);
        }
    }
}
