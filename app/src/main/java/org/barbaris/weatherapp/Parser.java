package org.barbaris.weatherapp;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.barbaris.weatherapp.Models.DataModel;

public class Parser extends Thread {
    private static final int FORECAST_DAYS  = 7;
    private final DataModel data;
    private final MainActivity activity;

    public Parser(DataModel data, MainActivity activity) {
        super();

        this.activity = activity;
        this.data = data;
    }

    @Override
    public void run() {
        super.run();

        String[] parsedData = new String[7];

        for(int i = 0; i < FORECAST_DAYS; i++) {
            // PARSING DATA FROM OBJECT
            String date = String.valueOf(data.getDataseries()[i].getDate());
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);

            String weather = weatherConvertor(data.getDataseries()[i].getWeather());
            String windSpeed = windSpeedConvertor(data.getDataseries()[i].getWind10m_max());
            int tempMax = data.getDataseries()[i].getTemp2m().getMax();
            int tempMin = data.getDataseries()[i].getTemp2m().getMin();

            @SuppressLint("DefaultLocale") String dayForecast = String.format("%s.%s.%s\r\nМАКСИМАЛЬНАЯ ТЕМПЕРАТУРА: %d°C\r\n" +
                    "МИНИМАЛЬНАЯ ТЕМПЕРАТУРА: %d°C\r\nПОГОДА: %s\r\nСКОРОСТЬ ВЕТРА: %s", day, month, year, tempMax, tempMin, weather, windSpeed);
            parsedData[i] = dayForecast;
        }

        ListView listView = activity.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, parsedData);
        listView.setAdapter(adapter);
    }

    private String windSpeedConvertor(int apiSpeed) {
        if(apiSpeed == 1) return "Ниже 0.3 м/с";
        if(apiSpeed == 2) return "0.3 - 3.4 м/с";
        if(apiSpeed == 3) return "3.4 - 8 м/с";
        if(apiSpeed == 4) return "8 - 10.8 м/с";
        if(apiSpeed == 5) return "10.8 - 17.2 м/с";
        if(apiSpeed == 6) return "17.2 - 24.5 м/с";
        if(apiSpeed == 7) return "24.5 - 32.6 м/с";
        if(apiSpeed == 8) return "Свыше 32.6 m/s";

        return "Н/Д";
    }

    private String weatherConvertor(String weather) {
        if(weather.equals("clear")) return "Ясно";
        if(weather.equals("pcloudy")) return "Слегка облачно";
        if(weather.equals("mcloudy")) return "Частично облачно";
        if(weather.equals("cloudy")) return "Облачно";
        if(weather.equals("lightrain")) return "Долгий лёгкий дождь";
        if(weather.equals("oshower") || weather.equals("ishower")) return "Кратковременный дождь";
        if(weather.equals("rain")) return "Дождь";
        if(weather.equals("lightsnow")) return "Небольшой снег";
        if(weather.equals("snow")) return "Снег";
        if(weather.equals("rainsnow")) return "Мокрый снег";
        if(weather.equals("humid")) return "Высокая влажность";

        return "Н/Д";
    }
}
