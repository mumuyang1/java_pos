package com.thoughtworks.vo;

/**
 * Created by liyanzi on 14-10-25.
 */
public class Item {
    private String barcode;
    private String name;
    private String unit;
    private double price;

    public Item(){

    }

    public Item(String barcode, String name, String unit, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
