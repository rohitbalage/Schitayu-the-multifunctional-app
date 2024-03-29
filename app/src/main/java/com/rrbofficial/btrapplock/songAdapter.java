package com.rrbofficial.btrapplock;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ROHIT on 10/09/2018.
 */

public class songAdapter extends RecyclerView.Adapter< songAdapter.SongHolder> {


    ArrayList<SongInfo>_songs ;
    Context context ;

    OnitemClickListener onitemClickListener;

    songAdapter(Context context,ArrayList<SongInfo>_songs){

        this.context=context;
        this._songs=_songs;
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View myview = LayoutInflater.from(context).inflate(R.layout.row_songs,viewGroup,false);
        return new SongHolder(myview);
    }

    public  interface  OnitemClickListener{
        void onItemClick(Button b,View v,SongInfo obj,int position);

    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener){
        this.onitemClickListener=onitemClickListener;
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
        final SongInfo c =_songs.get(i);
        songHolder.songName.setText(c.SongName);
        songHolder.artistName.setText(c.SongName);
        songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onitemClickListener!=null){

                    onitemClickListener.onItemClick(songHolder.btnAction,v,c,i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songName ,artistName ;
        Button btnAction ;
        public SongHolder(View itemView) {
            super(itemView);
            songName=(TextView)itemView.findViewById(R.id.tvSongName);
            artistName=(TextView)itemView.findViewById(R.id.tvArtistName);
            btnAction=(Button) itemView.findViewById(R.id.btnAction);
        }
    }
}
