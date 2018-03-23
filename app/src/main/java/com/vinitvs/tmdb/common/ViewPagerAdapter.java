package com.vinitvs.tmdb.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vinitvs.tmdb.ui.NowPlaying.NowPlayingFragment;
import com.vinitvs.tmdb.ui.UpcomingMovies.UpcomingMoviesFragment;

import static com.vinitvs.tmdb.util.Constants.TABS_TITLES;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment = null;
        switch (position) {
            case 0: {
                selectedFragment = NowPlayingFragment.newInstance();
                break;
            }
            case 1: {
                selectedFragment = UpcomingMoviesFragment.newInstance();
                break;
            }
            default: {
                selectedFragment = NowPlayingFragment.newInstance();
            }
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return TABS_TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABS_TITLES[position];
    }
}

