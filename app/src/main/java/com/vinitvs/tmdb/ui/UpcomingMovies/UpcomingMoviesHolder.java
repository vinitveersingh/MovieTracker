package com.vinitvs.tmdb.ui.UpcomingMovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinitvs.tmdb.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinit on 3/20/2018.
 */

public class UpcomingMoviesHolder extends RecyclerView.ViewHolder {
    public @BindView(R.id.txt_movieTitle)
    TextView movieTitle;

    public @BindView(R.id.txt_moviePopularity)
    TextView moviePopularity;

    public @BindView(R.id.txt_movieGenre)
    TextView movieGenre;

    public @BindView(R.id.img_moviePoster)
    ImageView imagePoster;


    public UpcomingMoviesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
