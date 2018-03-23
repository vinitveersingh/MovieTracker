package com.vinitvs.tmdb.core.dagger;


import com.vinitvs.tmdb.ui.NowPlaying.NowPlayingPresenter;
import com.vinitvs.tmdb.ui.UpcomingMovies.UpcomingMoviesPresenter;

import javax.inject.Singleton;

import dagger.Component;

/*
    Provide dependency injection of repository class as of now
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                RepositoryModule.class
        }
)

public interface AppComponent {

    void inject(NowPlayingPresenter nowPlayingPresenter);

    void inject(UpcomingMoviesPresenter upcomingMoviesPresenter);

}
