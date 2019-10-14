package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String jsonAPI = "{ \"coord\" : { \"lon\" : 139.01,\"lat\":35.02}," +
            "\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}]," +
            "\"base\":\"stations\"," +
            "\"main\":{\"temp\":285.514,\"pressure\":1013.75,\"humidity\":100,\"temp_min\":285.514," +
            "\"temp_max\":285.514,\"sea_level\":1023.22,\"grnd_level\":1013.75}," +
            "\"wind\":{\"speed\":5.52,\"deg\":311},\"clouds\":{\"all\":0},\"dt\":1485792967," +
            "\"sys\":{\"message\":0.0025,\"country\":\"JP\",\"sunrise\":1485726240," +
            "\"sunset\":1485763863},\"id\":1907296,\"name\":\"Tawarano\",\"cod\":200 }";

    TextView tvJson;
    String result, result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJson = findViewById(R.id.tvJson);

        try {

            JSONObject jsonObject = new JSONObject(jsonAPI);

            String coord = jsonObject.getString("coord");
            String weather = jsonObject.getString("weather");
            String base = jsonObject.getString("base");
            String main = jsonObject.getString("main");
            String wind = jsonObject.getString("wind");
            String clouds = jsonObject.getString("clouds");
            String dt = jsonObject.getString("dt");
            String sys = jsonObject.getString("sys");
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String cod = jsonObject.getString("cod");


            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            for(int i = 0; i < jsonArray.length(); i++){
                String wid = jsonArray.getJSONObject(i).getString("id");
                String wmain = jsonArray.getJSONObject(i).getString("main");
                String wdescription = jsonArray.getJSONObject(i).getString("description");
                String wicon = jsonArray.getJSONObject(i).getString("icon");

                result = result + "\nid : " + wid + ",main : " + wmain + ",description : " + wdescription
                        + ",icon : " + wicon;
            }

            JSONObject json0 = jsonObject.getJSONObject("coord");
            String lon = json0.getString("lon");
            String lat = json0.getString("lat");

            JSONObject json1 = jsonObject.getJSONObject("main");
            String temp = json1.getString("temp");
            String pressure = json1.getString("pressure");
            String humidity = json1.getString("humidity");
            String temp_min = json1.getString("temp_min");
            String temp_max = json1.getString("temp_max");
            String sea_level = json1.getString("sea_level");
            String grnd_level = json1.getString("grnd_level");

            result1 += temp + ", " + pressure + ", " + humidity + ", " + temp_min + ", " + temp_max
                    + ", " + sea_level + ", " + grnd_level;

            tvJson.setText("coord" + coord + "\n" + "lon:" + lon + ", lat:" + lat + "\n" + weather + "\n"
                            + result +"\n" + base + "\n" + wind + "\n" + main + "\n" + result1);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
