package com.restaurant.restaurant.Bean;

public class Greeting {

    private String city;
    private Integer category_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "city='" + city + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}