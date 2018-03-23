package com.vinitvs.tmdb.services.UpcomingMovies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.List;

/*Class required to Convert JsonObject to appropriate Model class when called using using RxJava2 and retrofit
  */
public class ResponseClassUpcoming {
    @SerializedName("results")
    @Expose
    private List<UpcomingMovies> upcomingMovies = null;

    public List<UpcomingMovies> getGenres() {
        return upcomingMovies;
    }

    public void setGenres(List<UpcomingMovies> upcomingMovies) {
        this.upcomingMovies = upcomingMovies;
    }
}

