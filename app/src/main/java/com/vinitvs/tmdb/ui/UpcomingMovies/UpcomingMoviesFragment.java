package com.vinitvs.tmdb.ui.UpcomingMovies;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vinitvs.tmdb.R;
import com.vinitvs.tmdb.common.MainActivity;
import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*Class to manage only the Views of Upcoming Movies Section  */

public class UpcomingMoviesFragment extends Fragment implements UpcomingMoviesContract.View {
    @BindView(R.id.rv_UpcomingMovies)
    RecyclerView mRecyclerUpcoming;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout mySwipeRefreshLayout;
    private View mRootView;
    private UpcomingMoviesPresenter mPresenterUpcoming;
    UpcomingPlayingAdapter mAdapterUpcoming;
    private List<UpcomingMovies> mListUpcoming;
    ProgressDialog progressDialog;

    public UpcomingMoviesFragment() {
        // Required empty public constructor
    }

    public static UpcomingMoviesFragment newInstance() {
        UpcomingMoviesFragment upcomingMoviesFragment = new UpcomingMoviesFragment();
        Bundle args = new Bundle();
        upcomingMoviesFragment.setArguments(args);
        return upcomingMoviesFragment;
    }

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        if (savedInstances == null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_upcoming_movies, container, false);
        mListUpcoming = new ArrayList<>();
        ButterKnife.bind(this, mRootView);
        mListUpcoming = new ArrayList<>();
        mAdapterUpcoming = new UpcomingPlayingAdapter(mListUpcoming, getActivity());
        mRecyclerUpcoming.setAdapter(mAdapterUpcoming);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerUpcoming.setLayoutManager(layoutManager);
        mPresenterUpcoming = new UpcomingMoviesPresenter(this, getContext());
        mPresenterUpcoming.loadUpComingMovies();

        /*Updates data when the Recycler View is scrolled down*/
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        MainActivity.makeApiCall();
                        mPresenterUpcoming.loadUpComingMovies();
                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
        return mRootView;
    }

    @Override
    public void showUpcomingMovies(List<UpcomingMovies> listUpcoming) {
        mAdapterUpcoming.updateData(listUpcoming);
    }

    public void showProgressDialog() {
        progressDialog = ProgressDialog.show(getContext(), "",
                "Loading. Please wait...", true);

    }

    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
