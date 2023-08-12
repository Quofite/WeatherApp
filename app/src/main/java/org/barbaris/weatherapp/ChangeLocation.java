package org.barbaris.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import org.barbaris.weatherapp.Models.CitiesCoordinates;

public class ChangeLocation extends AppCompatActivity {
    CitiesCoordinates citiesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_location);
        this.citiesData = new CitiesCoordinates();
    }

    public void setMoscow(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("city", citiesData.getMoscow());

        SharedPreferences preferences = getSharedPreferences("cityChoose", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putString("city", citiesData.getMoscow());
        editor.apply();

        startActivity(intent);
    }

    public void setYahroma(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("city", citiesData.getYahroma());

        SharedPreferences preferences = getSharedPreferences("cityChoose", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putString("city", citiesData.getYahroma());
        editor.apply();

        startActivity(intent);
    }

    public void setVurnari(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("city", citiesData.getVurnari());

        SharedPreferences preferences = getSharedPreferences("cityChoose", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putString("city", citiesData.getVurnari());
        editor.apply();

        startActivity(intent);
    }
}