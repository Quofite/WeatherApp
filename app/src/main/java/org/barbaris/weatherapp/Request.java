package org.barbaris.weatherapp;

import com.google.gson.Gson;
import org.barbaris.weatherapp.Models.DataModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request extends Thread {
    MainActivity activity;

    public Request(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        super.run();

        try {
            URL url = new URL("https://www.7timer.info/bin/api.pl?lon=37.58&lat=55.79&product=civillight&output=json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            reader.lines().forEach(l -> response.append(l + "\r\n"));
            reader.close();

            Gson gson = new Gson();
            DataModel data = gson.fromJson(response.toString(), DataModel.class);

            Parser parser = new Parser();
            parser.parse(data, activity);

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
