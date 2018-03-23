package com.vinitvs.tmdb.ui.UpcomingMovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.vinitvs.tmdb.R;
import com.vinitvs.tmdb.data.NowPlayingAndGenre.GenreData;
import com.vinitvs.tmdb.model.UpcomingMovies;

import java.util.List;

import static com.vinitvs.tmdb.util.Constants.BASE_IMAGE_URL;
import static com.vinitvs.tmdb.util.Constants.POPULARITY;

/**
 * Created by Vinit on 3/20/2018.
 */

public class UpcomingPlayingAdapter extends RecyclerView.Adapter<UpcomingMoviesHolder> {

    List<UpcomingMovies> mListUpcoming;
    private final Context mContext;

    UpcomingPlayingAdapter(List<UpcomingMovies> listUpcoming, Context mContext) {
        this.mListUpcoming = listUpcoming;
        this.mContext = mContext;
    }

    @Override
    public UpcomingMoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_upcoming_movies, parent, false);
        return new UpcomingMoviesHolder(v);
    }

    @Override
    public void onBindViewHolder(UpcomingMoviesHolder holder, int position) {
        holder.movieTitle.setText(mListUpcoming.get(position).getTitle());
        holder.moviePopularity.setText(POPULARITY + String.valueOf(mListUpcoming.get(position).getPopularity()));

        String genre = "";

        for (int i = 0; i < mListUpcoming.get(position).getGenre_ids().length; i++) {

            String g = GenreData.getHashMap().get(mListUpcoming.get(position).getGenre_ids()[i]);
            String comma = "";
            if (i > 0) {
                comma = " , ";
            }
            genre = genre + comma + g;
        }

        holder.movieGenre.setText(genre);
        Picasso.with(mContext).load(BASE_IMAGE_URL + mListUpcoming.get(position).getPoster_path()).into(holder.imagePoster);
    }

    @Override
    public int getItemCount() {
        return mListUpcoming.size();
    }

    /*Apart from the inbuilt methods of the RecyclerView Adapter this method is called whenever there is
      a change in the data to be displayed for example when the API is called again.
      */

    public void updateData(List<UpcomingMovies> listUpcoming) {
        this.mListUpcoming = listUpcoming;
        notifyDataSetChanged();
    }
}
