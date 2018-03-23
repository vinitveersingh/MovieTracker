package com.vinitvs.tmdb.services.NowPlayingAndGenre;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vinitvs.tmdb.model.Genre;

import java.util.List;

/*Class required to Convert JsonObject to appropriate Model class when called using using RxJava2 and retrofit
  */
public class ResponseClassGenre {
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}
