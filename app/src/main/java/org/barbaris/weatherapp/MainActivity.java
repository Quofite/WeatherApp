package org.barbaris.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.barbaris.weatherapp.Models.CitiesCoordinates;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CitiesCoordinates citiesData = new CitiesCoordinates();
        String city;

        try {
            city = getIntent().getExtras().get("city").toString();

            if(city.equals("")) {
                city = citiesData.getMoscow();
            }
        } catch (NullPointerException ex) {
            city = citiesData.getMoscow();
        }

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