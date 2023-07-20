package org.barbaris.weatherapp.Models;

public class DataModel {
    private String product;
    private String init;
    private DataSeriesModel[] dataseries;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public DataSeriesModel[] getDataseries() {
        return dataseries;
    }

    public void setDataseries(DataSeriesModel[] dataseries) {
        this.dataseries = dataseries;
    }
}
