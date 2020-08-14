package com.solution.toppop.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solution.toppop.R;

import java.util.ArrayList;
import java.util.Locale;

public class AlbumDetailsRecyclerAdapter extends RecyclerView.Adapter<AlbumDetailsRecyclerAdapter.AlbumDetailsRecyclerViewHolder> {

    private ArrayList<AlbumTrack> tracks;

    public class AlbumDetailsRecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView positionTextView;
        private TextView trackTitleTextView;
        private TextView durationTextView;

        public AlbumDetailsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            positionTextView = itemView.findViewById(R.id.indexTextView);
            trackTitleTextView = itemView.findViewById(R.id.trackTitleTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);
        }
    }

    public AlbumDetailsRecyclerAdapter(ArrayList<AlbumTrack> tracks){
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public AlbumDetailsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_recycler_item, parent, false);
        return new AlbumDetailsRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumDetailsRecyclerViewHolder holder, int position) {
        AlbumTrack currentItem = tracks.get(position);

        holder.positionTextView.setText(String.valueOf(position+1));
        holder.trackTitleTextView.setText(currentItem.getTitle());
        holder.durationTextView.setText(String.format(Locale.ENGLISH,"%02d:%02d", (currentItem.getDuration()/60), (currentItem.getDuration()%60)));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }
}
