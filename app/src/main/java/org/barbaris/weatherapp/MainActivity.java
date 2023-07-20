package org.barbaris.weatherapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Request request = new Request(this);
        try {
            request.start();
            request.join();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}