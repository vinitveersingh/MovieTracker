package com.vinitvs.tmdb.services.UpcomingMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.vinitvs.tmdb.util.Constants.API_KEY;
import static com.vinitvs.tmdb.util.Constants.UPCOMING;

    /*Interface required to make network call using Retrofit
      */

public interface Upcoming {
    @GET(UPCOMING + API_KEY)
    Observable<ResponseClassUpcoming> getUpcoming();

}
