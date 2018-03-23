package com.vinitvs.tmdb.data.NowPlayingAndGenre;

import java.util.HashMap;

/*This is where the genre objects is stored after getting it as a response from the API.
  Genre objects is required to convert genre ID to appropriate string to display to the user
 */
public class GenreData {

    private static HashMap<String, String> genreDataHashMap = new HashMap<>();

    public static HashMap<String, String> getHashMap() {
        return genreDataHashMap;
    }

    public static void setHashMap(HashMap<String, String> genreDataHashMapP) {
        genreDataHashMap = genreDataHashMapP;
    }
}

