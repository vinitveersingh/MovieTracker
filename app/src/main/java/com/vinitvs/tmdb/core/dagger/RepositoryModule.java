package com.vinitvs.tmdb.core.dagger;


import com.vinitvs.tmdb.ui.NowPlaying.NowPlayingRepository;
import com.vinitvs.tmdb.ui.UpcomingMovies.UpcomingMoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public NowPlayingRepository provideNowPlayingRepository() {
        return new NowPlayingRepository();
    }


    @Provides
    @Singleton
    public UpcomingMoviesRepository provideUpcomingMoviesRepository() {
        return new UpcomingMoviesRepository();
    }
}
