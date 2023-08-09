package org.barbaris.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.barbaris.weatherapp.Models.CitiesCoordinates;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("cityChoose", Context.MODE_PRIVATE);

        CitiesCoordinates citiesData = new CitiesCoordinates();
        String city = preferences.getString("city", citiesData.getMoscow());

        try {
            city = getIntent().getExtras().get("city").toString();

            if(city.equals("")) {
                city = citiesData.getMoscow();
            }
        } catch (NullPointerException ignored) {}

        TextView text = findViewById(R.id.city);
        text.setText(citiesData.getCityNameByCoord(city));

        Request request = new Request(this, city);
        try {
            request.start();
            request.join();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void changeLocationButton(View view) {
        Intent intent = new Intent(this, ChangeLocation.class);
        startActivity(intent);
    }
}