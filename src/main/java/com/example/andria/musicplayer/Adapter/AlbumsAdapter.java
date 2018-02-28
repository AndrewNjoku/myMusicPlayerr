
/*

package com.example.andria.musicplayer.Adapter;
import com.example.andria.musicplayer.R;



import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andria.musicplayer.Model.Results;

import java.util.List;
import com.example.andria.musicplayer.Model.Results;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView collection, Song, price;
        public ImageView AlbumCover;
        public CardView view;


        public MyViewHolder(View view) {
            super(view);

            view =  view.findViewById(R.id.card_view);

        }
    }


    public AlbumsAdapter(List<Results> resultsList) {
   //     this.mContext = mContext;
        this.resultsList = resultsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

             View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        System.out.println("hi we made it");
        Results album = resultsList.get(position);

        holder.collection.setText(album.getArtistName());
        holder.Song.setText(album.getTrackName());
        holder.price.setText(album.getTrackName());
        System.out.println(" inflating the damn adapter");

        // loading album cover using Glide library
      //  Glide.with(mContext).load(album.getArtworkUrl60()).into(holder.AlbumCover);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

*/
