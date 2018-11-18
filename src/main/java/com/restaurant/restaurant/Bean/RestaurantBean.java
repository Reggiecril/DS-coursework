package com.restaurant.restaurant.Bean;

public class RestaurantBean {
    private int id;
    private String  name;
    private String  url;
    private Location  location;
    private String   cuisines;
    private int average_cost_for_two;
    private String  currency;
    private Rating user_rating;
    private String photos_url;
    private String distance;
    private String duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public int getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(int average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Rating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(Rating user_rating) {
        this.user_rating = user_rating;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "RestaurantBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", location=" + location +
                ", cuisines='" + cuisines + '\'' +
                ", average_cost_for_two=" + average_cost_for_two +
                ", currency='" + currency + '\'' +
                ", user_rating=" + user_rating +
                ", photos_url='" + photos_url + '\'' +
                ", distance='" + distance + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
