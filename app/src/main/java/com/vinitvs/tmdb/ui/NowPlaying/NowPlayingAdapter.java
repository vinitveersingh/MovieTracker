package com.vinitvs.tmdb.ui.NowPlaying;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.vinitvs.tmdb.R;
import com.vinitvs.tmdb.data.NowPlayingAndGenre.GenreData;
import com.vinitvs.tmdb.model.NowPlaying;

import java.util.List;

import static com.vinitvs.tmdb.util.Constants.BASE_IMAGE_URL;
import static com.vinitvs.tmdb.util.Constants.POPULARITY;

/**
 * Created by Vinit on 3/20/2018.
 */

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingHolder> {

    List<NowPlaying> mnowPlayingsList;
    private final Context mContext;


    NowPlayingAdapter(List<NowPlaying> nowPlayings, Context mContext) {
        this.mnowPlayingsList = nowPlayings;
        this.mContext = mContext;
    }

    @Override
    public NowPlayingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_now_playing, parent, false);
        return new NowPlayingHolder(v);
    }

    @Override
    public void onBindViewHolder(NowPlayingHolder holder, int position) {
        holder.movieTitle.setText(mnowPlayingsList.get(position).getTitle());
        holder.moviePopularity.setText(POPULARITY + String.valueOf(mnowPlayingsList.get(position).getPopularity()));
        String genre = "";

        for (int i = 0; i < mnowPlayingsList.get(position).getGenre_ids().length; i++) {

            String g = GenreData.getHashMap().get(mnowPlayingsList.get(position).getGenre_ids()[i]);
            String comma = "";
            if (i > 0) {
                comma = " , ";
            }
            genre = genre + comma + g;
        }
        holder.movieGenre.setText(genre);
        Picasso.with(mContext).load(BASE_IMAGE_URL + mnowPlayingsList.get(position).getPoster_path()).into(holder.imagePoster);


    }

    @Override
    public int getItemCount() {
        return mnowPlayingsList.size();
    }

    /*Apart from the inbuilt methods of the RecyclerView Adapter this method is called whenever there is
  a change in the data to be displayed for example when the API is called again.
  */
    public void updateData(List<NowPlaying> nowPlayingsList) {
        this.mnowPlayingsList = nowPlayingsList;
        notifyDataSetChanged();
    }
}
