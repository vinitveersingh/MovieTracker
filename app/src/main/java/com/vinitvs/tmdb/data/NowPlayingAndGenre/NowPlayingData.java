package com.vinitvs.tmdb.data.NowPlayingAndGenre;

import com.vinitvs.tmdb.model.NowPlaying;

import java.util.ArrayList;
import java.util.List;


/*This is where the actual new movies data objects is stored after getting it as a response from the API.
 */
public class NowPlayingData {
    private static List<NowPlaying> nowPlayingList = new ArrayList<>();

    public static List<NowPlaying> getNowPlayingList() {
        return nowPlayingList;
    }

    public static void setNowPlayingList(List<NowPlaying> nowPlayingListP) {
        nowPlayingList = nowPlayingListP;
    }

}
