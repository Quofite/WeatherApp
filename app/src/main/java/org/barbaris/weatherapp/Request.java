package org.barbaris.weatherapp;

import com.google.gson.Gson;
import org.barbaris.weatherapp.Models.DataModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request extends Thread {
    MainActivity activity;
    private String city;

    public Request(MainActivity activity, String city) {
        this.activity = activity;
        this.city = city;
    }

    @Override
    public void run() {
        super.run();

        try {
            URL url = new URL(String.format("https://www.7timer.info/bin/api.pl?%s&product=civillight&output=json", city));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            reader.lines().forEach(l -> response.append(l).append("\r\n"));
            reader.close();

            Gson gson = new Gson();
            DataModel data = gson.fromJson(response.toString(), DataModel.class);

            Parser parser = new Parser(data, activity);
            parser.start();

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
