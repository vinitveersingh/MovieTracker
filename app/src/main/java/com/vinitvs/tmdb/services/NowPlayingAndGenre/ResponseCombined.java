package com.vinitvs.tmdb.services.NowPlayingAndGenre;

/*Combined Class required to Convert JsonObject to appropriate Model class when parallel api requests are
  made using using RxJava2 and retrofit
 */

public class ResponseCombined {

    public ResponseClassNowPlaying nowPlaying;
    public ResponseClassGenre genre;

    public ResponseCombined(ResponseClassNowPlaying nowPlaying, ResponseClassGenre genre) {
        this.nowPlaying = nowPlaying;
        this.genre = genre;
    }
}

