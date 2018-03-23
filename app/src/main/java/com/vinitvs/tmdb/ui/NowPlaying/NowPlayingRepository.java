package com.vinitvs.tmdb.ui.NowPlaying;

import com.vinitvs.tmdb.data.NowPlayingAndGenre.NowPlayingData;
import com.vinitvs.tmdb.model.NowPlaying;

import java.util.List;


/*
  The repository provides and abstraction for where the data is stored.
  Right now is contains only one method but suppose in the future we might want to delete
  or add something to the data source( E.g : Database , Shared preference, etc) we can do it from
  adding more functions here.
 */

public class NowPlayingRepository implements NowPlayingContract.Repository {

    @Override
    public List<NowPlaying> getNowPlayingListFromData() {
        return NowPlayingData.getNowPlayingList();
    }

}
