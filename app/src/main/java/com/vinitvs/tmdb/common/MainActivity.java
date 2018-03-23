package com.vinitvs.tmdb.common;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.vinitvs.tmdb.R;
import com.vinitvs.tmdb.services.NowPlayingAndGenre.NowPlay;
import com.vinitvs.tmdb.services.NowPlayingAndGenre.ResponseClassGenre;
import com.vinitvs.tmdb.services.NowPlayingAndGenre.ResponseClassNowPlaying;
import com.vinitvs.tmdb.services.NowPlayingAndGenre.ResponseCombined;
import com.vinitvs.tmdb.services.UpcomingMovies.ResponseClassUpcoming;
import com.vinitvs.tmdb.services.UpcomingMovies.Upcoming;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vinitvs.tmdb.util.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;


    public static Observable<ResponseCombined> combined;
    public static Observable<ResponseClassUpcoming> upcomingObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Make api call and get stream of observables of required type
        makeApiCall();
        //Set Up view pager with tab layout to show now playing and upcoming movies
        setViewPager();
        setTabLayout();
        tabLayout.setupWithViewPager(viewPager);

    }

    public static void makeApiCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Observable<ResponseClassNowPlaying> nowPlayingObservable = retrofit
                .create(NowPlay.class)
                .getNowPlaying()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<ResponseClassGenre> genreObservable = retrofit
                .create(NowPlay.class)
                .getGenre()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        /*
        * Make parallel network request and combine their result
        * */
        combined = Observable.zip(nowPlayingObservable, genreObservable, new BiFunction<ResponseClassNowPlaying, ResponseClassGenre, ResponseCombined>() {
            @Override
            public ResponseCombined apply(ResponseClassNowPlaying jsonObject, ResponseClassGenre jsonElements) throws Exception {
                return new ResponseCombined(jsonObject, jsonElements);
            }
        });

        upcomingObservable = retrofit
                .create(Upcoming.class)
                .getUpcoming()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    private void setTabLayout() {
        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText(R.string.now_playing);
        tabLayout.addTab(tab1);

        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText(R.string.upcoming_movies);
        tabLayout.addTab(tab2);

    }

    private void setViewPager() {
        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fm);
        viewPager.setAdapter(viewPagerAdapter);
    }


}

