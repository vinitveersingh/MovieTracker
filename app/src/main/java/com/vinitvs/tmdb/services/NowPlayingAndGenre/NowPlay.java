package com.vinitvs.tmdb.services.NowPlayingAndGenre;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.vinitvs.tmdb.util.Constants.API_KEY;
import static com.vinitvs.tmdb.util.Constants.LANGUAGE;
import static com.vinitvs.tmdb.util.Constants.NOW_PLAYING;
import static com.vinitvs.tmdb.util.Constants.GENRE;

/**
 * Created by Vinit on 3/21/2018.
 */

public interface NowPlay {
    @GET(NOW_PLAYING + API_KEY)
    Observable<ResponseClassNowPlaying> getNowPlaying();

    @GET( GENRE + API_KEY + LANGUAGE)
    Observable<ResponseClassGenre> getGenre();

}
