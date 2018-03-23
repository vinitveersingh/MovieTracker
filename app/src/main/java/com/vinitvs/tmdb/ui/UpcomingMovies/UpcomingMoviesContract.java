package com.vinitvs.tmdb.ui.UpcomingMovies;

import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.List;

/**
 * Created by Vinit on 3/20/2018.
 */

public interface UpcomingMoviesContract {
    public interface View{
        public void showUpcomingMovies(List<UpcomingMovies> nowPlayings);

        public void showProgressDialog();

        public void dismissProgressDialog();
    }

    public interface Action{
        public void loadUpComingMovies();
    }

    public interface Repository{
        public List<UpcomingMovies> getUpcomingMoviesFromData();
    }
}
