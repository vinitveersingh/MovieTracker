package com.vinitvs.tmdb.ui.UpcomingMovies;

import android.content.Context;

import com.vinitvs.tmdb.core.TMDB;
import com.vinitvs.tmdb.data.UpcomingMovieData.UpcomingMovieData;
import com.vinitvs.tmdb.model.UpcomingMovies;
import com.vinitvs.tmdb.services.UpcomingMovies.ResponseClassUpcoming;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.vinitvs.tmdb.common.MainActivity.upcomingObservable;

/*Class to manage only the business logic of Upcoming Movies Section.  */


public class UpcomingMoviesPresenter implements UpcomingMoviesContract.Action {


    Context mContext;
    private final UpcomingMoviesContract.View mViewUpcoming;

    @Inject
    UpcomingMoviesRepository upcomingMoviesRepository;

    UpcomingMoviesPresenter(UpcomingMoviesContract.View view , Context context) {
        this.mViewUpcoming = view;
        this.mContext = context;
        TMDB.getInstance().getAppComponent().inject(this);
    }


    /*This method consumes the data got from calling the observables and puts it the repository.
      The repository is called using dagger and the data is passed on to the View to display.
     */
    @Override
    public void loadUpComingMovies() {
        /*
        * Show progress bar to user to let them know data is loading.
        * */
        mViewUpcoming.showProgressDialog();
        upcomingObservable.subscribe(new Observer<ResponseClassUpcoming>() {
                                         @Override
                                         public void onSubscribe(Disposable d) {

                                         }

                                         @Override
                                         public void onNext(ResponseClassUpcoming value) {
                                             UpcomingMovieData.setListUpcoming(value.getGenres());

                                             try {
                                                 Thread.sleep(1000);
                                             } catch (InterruptedException e) {
                                                 e.printStackTrace();
                                             }
                                         }

                                         @Override
                                         public void onError(Throwable e) {

                                         }

                                         @Override
                                         public void onComplete() {
                                             List<UpcomingMovies> upcomingMoviesList = upcomingMoviesRepository.getUpcomingMoviesFromData();
                                             mViewUpcoming.showUpcomingMovies(upcomingMoviesList);
                                             mViewUpcoming.dismissProgressDialog();

                                         }
                                     }

        );
    }

}
