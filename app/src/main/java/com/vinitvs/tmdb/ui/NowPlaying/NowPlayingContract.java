package com.vinitvs.tmdb.ui.NowPlaying;

import com.vinitvs.tmdb.model.NowPlaying;

import java.util.List;

/**
 * Created by Vinit on 3/20/2018.
 */

public interface NowPlayingContract {
    public interface View{
        public void showNowPlayingMovies(List<NowPlaying> nowPlayings);
        public void showProgressDialog();
        public void dismissProgressDialog();
    }

    public interface Action{
        public void loadNowPlayingMovies();
    }

    public interface Repository{
        public List<NowPlaying> getNowPlayingListFromData();
    }
}
