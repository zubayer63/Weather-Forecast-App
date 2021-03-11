package com.example.zubayer.weatherapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Zubayer on 08-Sep-18.
 */

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.MyViewHolder> {
    Context context;
    ArrayList<Example2> hourTemp;

    public RecyclerAdapter2(Context context, ArrayList<Example2> hourTemp) {
        this.context = context;
        this.hourTemp = hourTemp;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout2,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.dayText.setText(hourTemp.get(position).getList().get(position).getDtTxt());
        Picasso.with(context).load("http://openweathermap.org/img/w/"+hourTemp.get(position).getList().get(position)
                .getWeather().get(0).getIcon()+".png").resize(110,100).into(holder.imageView);

        holder.tempText.setText(hourTemp.get(position).getList().get(position).getMain().getTemp()+"°c");

    }

    @Override
    public int getItemCount() {
        return hourTemp.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView dayText,tempText;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            tempText=itemView.findViewById(R.id.temp);
            dayText=itemView.findViewById(R.id.date);
            imageView=itemView.findViewById(R.id.Image);
        }
    }
}
