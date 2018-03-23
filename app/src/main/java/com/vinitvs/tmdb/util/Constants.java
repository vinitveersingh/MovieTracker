package com.vinitvs.tmdb.util;

/**
    Constant Class that holds Immutable String data that will be used to call apis or display data
 */

public class Constants {
    public static final String BASE_URL = "https://api.themoviedb.org/";
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185//";
    public static final String UPCOMING = "3/movie/upcoming?";
    public static final String NOW_PLAYING = "3/movie/now_playing?";
    public static final String GENRE = "3/genre/movie/list?";
    public static final String LANGUAGE = "&language=en-US&page=1";
    public static final String API_KEY = "api_key=04d0d3308e89bfcbc8a8fe91cd9f9683";
    public static final String[] TABS_TITLES = {"Now Playing", "Upcoming Movies"};
    public static final String POPULARITY = "Popularity : ";

}
