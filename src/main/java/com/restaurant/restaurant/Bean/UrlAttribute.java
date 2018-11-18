package com.restaurant.restaurant.Bean;

public class UrlAttribute {
    private String city;
    private int category;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        category = category;
    }

    @Override
    public String toString() {
        return "UrlAttribute{" +
                "city='" + city + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
