package com.example.zubayer.weatherapi;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ApiInterface apiInterface, apiInterface2;
    RecyclerView myrecyclerView;
    TextView daytemp, locationText, dateText, timeText, dayText;
    ImageView imageView;
    String timeFormat = "";
    TextView humidity, cloud, pressure, sunrise, sunset, maxtemp, dewpoint, descrip, rain, rain2;
    EditText editText;
    Button nextBtn;

    TextView textView;
    String curDate2, curMonth;
    String mName;
    String[] mDay;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        linearLayout = findViewById(R.id.myLayout);


        nextBtn = findViewById(R.id.NxtBtn);
        //  editText = findViewById(R.id.EditText);
        //srcButton = findViewById(R.id.src);
        daytemp = findViewById(R.id.tmpText);
        locationText = findViewById(R.id.location);
        //listView=findViewById(R.id.mylistView);


        humidity = findViewById(R.id.Humidity);
        cloud = findViewById(R.id.Cloud);
        pressure = findViewById(R.id.Pressure);
        sunrise = findViewById(R.id.Sunrise);
        sunset = findViewById(R.id.Sunset);
        maxtemp = findViewById(R.id.Maxtemp);
        dewpoint = findViewById(R.id.Dewpoint);
        descrip = findViewById(R.id.Description);
        // rain=findViewById(R.id.Rain);
        rain2 = findViewById(R.id.Rain2);


        timeText = findViewById(R.id.Time); //For adding Time
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("h:mm a");
        String time = simpleTimeFormat.format(calendar1.getTime());
        timeText.setText(time);


       /* Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour,min); //Methode*/

        dayText = findViewById(R.id.Day);
        SimpleDateFormat simpleWeekFormat = new SimpleDateFormat("EEEE");
        String curDay = simpleWeekFormat.format(calendar1.getTime());
        dayText.setText(curDay);
        //String weekDay=calendar1.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
        //dayText.setText(weekDay);


        dateText = findViewById(R.id.Date); ///For adding Date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM -yyyy");
        String curDate = simpleDateFormat.format(calendar1.getTime());
        dateText.setText(curDate);

        //Date date=new Date();//inisializing date class;
        // DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplication()); // inisializing dateformating;
        //dateText.setText(dateFormat.format(date)); //Set Date and formate ;//End


        imageView = findViewById(R.id.icon); //For icon
        ViewGroup.LayoutParams params = imageView.getLayoutParams(); //For increasing size of imageview;
        params.width = 100;
        params.height = 100;
        imageView.setLayoutParams(params); ///End;
        imageView.getResources(); //find image by piccasso dependancy;


        myrecyclerView = findViewById(R.id.myRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myrecyclerView.setLayoutManager(layoutManager);
        myrecyclerView.setHasFixedSize(true);


        //Call call2=apiInterface.getExample();
        /*call2.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Example example2= (Example) response.body();

               ArrayList<Example> tempArray2=new ArrayList<>();
               for(int i=0;i<example2.getList().size();i++){
                   tempArray2.add(example2);
                   Log.i("student1", String.valueOf(tempArray2));
              }

                RecyclerAdapter adapter=new RecyclerAdapter(getApplicationContext(),tempArray2);
                myrecyclerView.setAdapter(adapter);
                Log.i("student1", String.valueOf(tempArray2.size()));




            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplication(),"Fail",Toast.LENGTH_SHORT).show();

            }
        });*/

        //      srcButton.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //      public void onClick(View v) {
        //   String location = editText.getText().toString();

        Intent intent = getIntent();
        String location = intent.getExtras().getString("loc");
        final String endUrl = "daily?q=" + location + "&mode=json&units=metric&cnt=14&&appid=b505284cc7606e04108e38cdaead2570";

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("end", endUrl);
                startActivity(intent);

            }
        });

        String endUrl3 = "forecast?q=" + location + "&mode=json&units=metric&&appid=b505284cc7606e04108e38cdaead2570";

        apiInterface = ApiClient.getApiClient3().create(ApiInterface.class);
        Call call = apiInterface.getExample3(endUrl3);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                Example2 example = (Example2) response.body();

                ArrayList<Example2> hourTemp = new ArrayList<>();

                for (int i = 0; i < example.getList().size(); i++) {
                    hourTemp.add(example);
                }
                RecyclerAdapter2 adapter = new RecyclerAdapter2(getApplicationContext(), hourTemp);
                myrecyclerView.setAdapter(adapter);


              /*

              myArray.add(example.getCity().getCountry());
               myArray.add(example.getCity().getName());
               myArray.add(example.getCity().getPopulation()+"");
                for(int i=0;i<example.getList().size();i++){
                   myArray.add(example.getList().get(0).getTemp().getDay()+"");

                   myArray.add(example.getList().get(0).getClouds()+"");
                    myArray.add(example.getList().get(0).getDeg()+"");
                      String a= String.valueOf(myArray.add(example.getList().get(0).getTemp().getDay()+""));

                    myArray.add(example.getList().get(i).getWeather().get(i).getIcon());

               }*/


                String dayTemp = example.getList().get(0).getMain().getTemp() + " °C ";
                // Double dayTemp=example.getList().get(0).getTemp().getDay();
                daytemp.setText(dayTemp);

                String loc = example.getCity().getName();
                locationText.setText(loc);


                String iconUrl = "http://api.openweathermap.org/img/w/" + example.getList().get(0).getWeather()
                        .get(0).getIcon() + ".png";
                Picasso.with(getApplication()).load(iconUrl).into(imageView);


                String minTemp = example.getList().get(0).getMain().getTempMin() + "°C";
                // String maxTemp = example.getList().get(0).getMain().getTempMax() + "°C";
                // String pRain=example.getList().get(0).getRain()+"p";
                // String cRain = example.getList().get(0).getClouds() + "%";

                dewpoint.setText("Dewpoint    :   " + minTemp);

                backgroudImageChange(example.getList().get(0).getWeather().get(0).getMain());
                //maxtemp.setText("Maxtemp   :   " + maxTemp);
                // rain.setText(pRain);
                //rain2.setText(cRain);


               /*
                ArrayList<String> myArray=new ArrayList<>();
                myArray.add(example.getList().get(0).getHumidity()+"%");
                myArray.add(example.getList().get(0).getPressure()+"");
                myArray.add(example.getList().get(0).getTemp().getMin()+" °C");

                myArray.add(example.getList().get(0).getWeather().get(0).getDescription());

                ArrayAdapter<String> myadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,myArray);
                listView.setAdapter(myadapter);
                */

            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });


        String endUrl2 = "weather?q=" + location + "&units=metric&&appid=b505284cc7606e04108e38cdaead2570";

        apiInterface2 = ApiClient.getApiclient2().create(ApiInterface.class);
        Call call2 = apiInterface2.getExample2(endUrl2);
        call2.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                ExWeather exWeather = (ExWeather) response.body();


                Integer humi = exWeather.getMain().getHumidity();
                Integer rain = exWeather.getClouds().getAll();
                Double pres = exWeather.getMain().getPressure();
                Integer sunRise = exWeather.getSys().getSunrise();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
                Date date = new Date(sunRise * 1000L);
                String riseTime = simpleDateFormat.format(date);

                Integer sunSet = exWeather.getSys().getSunset();
                Date date2 = new Date(sunSet * 1000L);
                String setTime = simpleDateFormat.format(date2);


                ;
                //Double dewPoint=exWeather.getMain().getTempMin();
                String descr = exWeather.getWeather().get(0).getDescription();

                humidity.setText("Humidity  :   " + humi + " %");
                cloud.setText("Probability of rain :  " + rain + " %");
                pressure.setText("Pressure  :   " + pres + " hPa");
                sunrise.setText("Sunrise    :  " + riseTime);
                sunset.setText("Sunset      :   " + setTime);
                descrip.setText("Description    :   " + descr);
                maxtemp.setText("MaxTemp  :   " + exWeather.getMain().getTempMax() + "°C");

                // dewpoint.setText("DewPoint  :   "+dewPoint +"°C");

            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                Log.i("fail6", t.getMessage());
            }
        });

//            }
        //});


        textView = findViewById(R.id.textview);


        Calendar calendar3 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatt = new SimpleDateFormat("dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMMM");
        curDate2 = simpleDateFormatt.format(calendar3.getTime());

        curMonth = simpleDateFormat2.format(calendar3.getTime());


        if (getResources().getResourceEntryName(R.array.January).equals(curMonth)) {
            mName = "january";
            mDay = getResources().getStringArray(R.array.January);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.February).equals(curMonth)) {
            mName = "february";
            mDay = getResources().getStringArray(R.array.February);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.March).equals(curMonth)) {
            mName = "march";
            mDay = getResources().getStringArray(R.array.March);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.April).equals(curMonth)) {
            mName = "april";
            mDay = getResources().getStringArray(R.array.April);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.May).equals(curMonth)) {
            mName = "may";
            mDay = getResources().getStringArray(R.array.May);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.June).equals(curMonth)) {
            mName = "june";
            mDay = getResources().getStringArray(R.array.June);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.July).equals(curMonth)) {
            mName = "july";
            mDay = getResources().getStringArray(R.array.July);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.August).equals(curMonth)) {
            mName = "august";
            mDay = getResources().getStringArray(R.array.August);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.September).equals(curMonth)) {
            mName = "september";
            mDay = getResources().getStringArray(R.array.September);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.October).equals(curMonth)) {
            mName = "october";
            mDay = getResources().getStringArray(R.array.October);
            //textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.November).equals(curMonth)) {
            mName = "november";
            mDay = getResources().getStringArray(R.array.November);
            // textView.setText(mName);
        } else if (getResources().getResourceEntryName(R.array.December).equals(curMonth)) {
            mName = "december";
            mDay = getResources().getStringArray(R.array.December);
            //   textView.setText(mName);
        }



       /* for(int i=0;i<=30;i++){
            monthResult(mName,mDay[i]);
            Log.i("day",mDay[i]);
        }*/
        monthResult(mName);
        //Log.i("f0",curDate);


    }

    void backgroudImageChange(String climate)
    {
        if (climate.equals("Thunderstorm"))
        {

            linearLayout.setBackgroundResource(R.drawable.thunder);
        }
       else if (climate.equals("Rain"))
        {

            linearLayout.setBackgroundResource(R.drawable.rain);
        }
       else if (climate.equals("Clouds"))
        {
            linearLayout.setBackgroundResource(R.drawable.clouds3);

        }
       else if (climate.equals("Atmosphere"))
        {

            linearLayout.setBackgroundResource(R.drawable.mist);
        }
       else if (climate.equals("Clear"))
        {
            linearLayout.setBackgroundResource(R.drawable.sky);
        }

        else if (climate.equals("Drizzle"))
        {
            linearLayout.setBackgroundResource(R.drawable.rain4);
        }

    }

    void monthResult(String monthName) {
        // Log.i("tt",monthName);
        //  Log.i("tt2",date);

        if (monthName.equals(mName)) {

            textView.setText("Predict Temp For Next Year : " + mDay[Integer.parseInt(curDate2)]);
        }


        return;


    }

}

//--------------------- For formating time and set time -------------------;
  /*  public  void showTime(int hour,int min){

        if(hour==0){
            hour+=12;
            timeFormat="AM";
        }
        else if(hour==12){
            timeFormat="PM";
        }
        else if(hour>12){
            hour-=12;
            timeFormat="PM";

        }
        else{
            timeFormat="AM";
        }
        timeText.setText(new StringBuilder().append(hour).append(":").append(min).append(" ").append(timeFormat));

    }*/





