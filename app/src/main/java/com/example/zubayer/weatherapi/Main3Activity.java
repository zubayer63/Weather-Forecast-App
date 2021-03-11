package com.example.zubayer.weatherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main3Activity extends AppCompatActivity {
    RecyclerView myrecyclerView;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myrecyclerView = findViewById(R.id.myRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String endUrl= intent.getExtras().getString("end");

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call call = apiInterface.getExample(endUrl);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                Example example = (Example) response.body();

                ArrayList<Example> tempArray = new ArrayList<>();

                for (int i = 0; i < example.getList().size(); i++) {
                    tempArray.add(example);
                }
                RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(), tempArray);
                myrecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

    }
}
