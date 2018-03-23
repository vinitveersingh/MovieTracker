package com.vinitvs.tmdb.ui.UpcomingMovies;

import com.vinitvs.tmdb.data.UpcomingMovieData.UpcomingMovieData;
import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.List;

/**
 * Created by Vinit on 3/20/2018.
 */

public class UpcomingMoviesRepository implements UpcomingMoviesContract.Repository {

    /*
      The repository provides and abstraction for where the data is stored.
      Right now is contains only one method but suppose in the future we might want to delete
      or add something to the data source( E.g : Database , Shared preference, etc) we can do it from
      adding more functions here.
     */

    @Override

    public List<UpcomingMovies> getUpcomingMoviesFromData() {
        return UpcomingMovieData.getUpcomingMovies();
    }
}
