package com.vinitvs.tmdb.core;

import android.app.Application;

import com.vinitvs.tmdb.core.dagger.AppComponent;
import com.vinitvs.tmdb.core.dagger.AppModule;
import com.vinitvs.tmdb.core.dagger.DaggerAppComponent;


/**
 * Created by Vinit on 3/11/2018.
 */

public class TMDB extends Application {

    private static AppComponent appComponent;
    private static TMDB instance = new TMDB();

    public static TMDB getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {

            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }

        return appComponent;
    }
}
