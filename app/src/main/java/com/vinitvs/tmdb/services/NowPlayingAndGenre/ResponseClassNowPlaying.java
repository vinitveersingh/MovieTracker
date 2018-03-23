package com.vinitvs.tmdb.services.NowPlayingAndGenre;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vinitvs.tmdb.model.NowPlaying;

import java.util.List;

/*Class required to Convert JsonObject to appropriate Model class when called using using RxJava2 and retrofit
  */

public class ResponseClassNowPlaying {
    @SerializedName("results")
    @Expose
    private List<NowPlaying> nowPlayings = null;

    public List<NowPlaying> getNowPlayings() {
        return nowPlayings;
    }

    public void setNowPlayings(List<NowPlaying> nowPlayings) {
        this.nowPlayings = nowPlayings;
    }


}
