package com.example.day11.manage.movieRating;

public class Movie implements Comparable<Movie>{
    private String title;
    private int year;
    private double rate;

    public Movie(String title, int year, double rate) {
        this.title = title;
        this.year = year;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.getTitle());
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title +
                ", year=" + year +
                ", rate=" + rate +
                '}';
    }
}
