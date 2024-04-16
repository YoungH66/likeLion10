package com.example.day11.manage.movieRating;

import java.util.Comparator;

public class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return Double.compare(movie1.getYear(), movie2.getYear());
    }
}
