package com.example.day11.manage.movieRating;

import java.util.*;

public class RatingComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2){
        return Double.compare(o1.getRate(), o2.getRate());
    }

}
