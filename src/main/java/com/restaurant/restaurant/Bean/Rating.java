package com.restaurant.restaurant.Bean;

public class Rating {
    private double aggregate_rating;
    private String rating_text;
    private String rating_color;
    private int votes;

    public double getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(double aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "aggregate_rating=" + aggregate_rating +
                ", rating_text='" + rating_text + '\'' +
                ", rating_color='" + rating_color + '\'' +
                ", votes=" + votes +
                '}';
    }
}
