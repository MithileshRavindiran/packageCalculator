package com.mobiquityinc.domain;

/**
 * Domain object for the Item
 *
 * Created by Mithilesh Ravindran .
 */
public class Item {

    private int id;

    private double weight;

    private double price;

    private String currency;

    public Item(int id, double weight, double price, String currency) {
        this.id = id;
        this.weight = weight;
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
