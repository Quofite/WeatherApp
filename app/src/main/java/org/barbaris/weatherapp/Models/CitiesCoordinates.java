package org.barbaris.weatherapp.Models;

public class CitiesCoordinates {
    private final String moscow = "lon=37.58&lat=55.79";
    private final String yahroma = "lon=37.48&lat=56.28";
    private final String vurnari = "lon=46.96&lat=55.48";

    public String getMoscow() {
        return moscow;
    }

    public String getYahroma() {
        return yahroma;
    }

    public String getVurnari() {
        return vurnari;
    }

    public String getCityNameByCoord(String coordinates) {
        switch (coordinates) {
            case moscow: return "Москва";
            case yahroma: return "Яхрома";
            case vurnari: return "Вурнары";
            default: return "Н/Д";
        }
    }
}
