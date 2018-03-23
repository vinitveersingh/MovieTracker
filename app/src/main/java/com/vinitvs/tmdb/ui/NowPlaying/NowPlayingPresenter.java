package com.vinitvs.tmdb.ui.NowPlaying;

import com.vinitvs.tmdb.common.MainActivity;
import com.vinitvs.tmdb.core.TMDB;
import com.vinitvs.tmdb.data.NowPlayingAndGenre.GenreData;
import com.vinitvs.tmdb.data.NowPlayingAndGenre.NowPlayingData;
import com.vinitvs.tmdb.model.NowPlaying;
import com.vinitvs.tmdb.services.NowPlayingAndGenre.ResponseCombined;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*Class to manage only the business logic of Now Playing Movies Section.  */


public class NowPlayingPresenter implements NowPlayingContract.Action {

    private final NowPlayingContract.View mnowPlayingView;

    @Inject
    NowPlayingRepository mnowPlayingRepositoryObject;

    NowPlayingPresenter(NowPlayingContract.View view) {
        mnowPlayingView = view;
        TMDB.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void loadNowPlayingMovies() {
        mnowPlayingView.showProgressDialog();
        MainActivity.combined.subscribe(new Observer<ResponseCombined>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseCombined value) {
                NowPlayingData.setNowPlayingList(value.nowPlaying.getNowPlayings());
                HashMap<String, String> genreHashMap = new HashMap<>();
                for (int i = 0; i < value.genre.getGenres().size(); i++) {
                    genreHashMap.put(value.genre.getGenres().get(i).getId(), value.genre.getGenres().get(i).getName());
                }
                GenreData.setHashMap(genreHashMap);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                List<NowPlaying> nowPlayingObjectList = mnowPlayingRepositoryObject.getNowPlayingListFromData();
                mnowPlayingView.showNowPlayingMovies(nowPlayingObjectList);
                mnowPlayingView.dismissProgressDialog();
            }
        });

    }

}
