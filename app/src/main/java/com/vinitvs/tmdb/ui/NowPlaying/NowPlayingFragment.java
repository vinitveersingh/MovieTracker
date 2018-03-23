package com.vinitvs.tmdb.ui.NowPlaying;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vinitvs.tmdb.R;
import com.vinitvs.tmdb.common.MainActivity;
import com.vinitvs.tmdb.model.NowPlaying;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*Class to manage only the Views of Upcoming Movies Section  */

public class NowPlayingFragment extends Fragment implements NowPlayingContract.View {

    @BindView(R.id.rv_NowMovies)
    RecyclerView recyclerViewMovies;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;


    private boolean debug = false;
    private View mRootView;
    private NowPlayingPresenter nowPlayingPresenter;
    NowPlayingAdapter nowPlayingAdapter;
    private List<NowPlaying> nowPlayings;
    ProgressDialog progressDialog;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    public static NowPlayingFragment newInstance() {
        NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
        Bundle args = new Bundle();
        nowPlayingFragment.setArguments(args);
        return nowPlayingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        if (savedInstances == null) {
            if (debug) {
                Log.i("DEBUG", "has arguments");
            }
        } else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, mRootView);
        nowPlayings = new ArrayList<>();
        nowPlayingAdapter = new NowPlayingAdapter(nowPlayings, getActivity());
        recyclerViewMovies.setAdapter(nowPlayingAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerViewMovies.setLayoutManager(layoutManager);
        nowPlayingPresenter = new NowPlayingPresenter(this);
        nowPlayingPresenter.loadNowPlayingMovies();
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener()

                {
                    @Override
                    public void onRefresh() {
                        Log.i("Movies Refresh Start", "-------------------------------------------------------");
                        MainActivity.makeApiCall();
                        nowPlayingPresenter.loadNowPlayingMovies();
                        Log.i("Movies Refresh End", "------------------------------------------------------");
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
        return mRootView;
    }

    @Override
    public void showNowPlayingMovies(List<NowPlaying> nowPlayingObjectList) {
        nowPlayingAdapter.updateData(nowPlayingObjectList);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = ProgressDialog.show(getContext(), "",
                "Loading. Please wait...", true);

    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
