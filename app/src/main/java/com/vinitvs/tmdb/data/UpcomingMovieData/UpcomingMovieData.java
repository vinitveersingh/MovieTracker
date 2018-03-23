package com.vinitvs.tmdb.data.UpcomingMovieData;

import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.ArrayList;
import java.util.List;

/*This is where the actual upcoming movies data objects is stored after getting it as a response from the API.
 */

public class UpcomingMovieData {
    private static List<UpcomingMovies> upcomingMoviesList = new ArrayList<>();

    public static List<UpcomingMovies> getUpcomingMovies() {
        return upcomingMoviesList;
    }

    public static void setListUpcoming(List<UpcomingMovies> upcomingMoviesListP) {
        upcomingMoviesList = upcomingMoviesListP;
    }
}
