package com.example.mangeshaher.softapplication;

/**
 * Created by mangeshaher on 2/11/17.
 */

public class Row {
    private String name;
    private int price,rating;

    public Row(String name, int price, int rating) {
        this.setName(name);
        this.setPrice(price);
        this.setRating(rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
