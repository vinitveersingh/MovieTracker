package com.vinitvs.tmdb.core.dagger;

import android.content.Context;


import com.vinitvs.tmdb.core.TMDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private final TMDB tmdb;

    public AppModule(TMDB tmdb) {
        this.tmdb = tmdb;
    }


    @Provides
    @Singleton
    public TMDB provideTMDBApplication() {
        return tmdb;
    }


    @Provides
    @Singleton
    public Context provideContext() {
        return (Context) tmdb;
    }
}