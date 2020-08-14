package com.solution.toppop.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solution.toppop.R;
import com.solution.toppop.details.AlbumDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Track> tracks;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView positionTextView;
        private ImageView artistImageView;
        private TextView songTextView;
        private TextView artistTextView;
        private TextView durationTextView;

        private RecyclerViewHolder(@NonNull View itemView, final ArrayList<Track> tracks) {
            super(itemView);
            positionTextView = itemView.findViewById(R.id.positionTextView);
            artistImageView = itemView.findViewById(R.id.artistImageView);
            songTextView = itemView.findViewById(R.id.songTextView);
            artistTextView = itemView.findViewById(R.id.artistTextView);
            durationTextView = itemView.findViewById(R.id.durationTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = Integer.parseInt(positionTextView.getText().toString());
                    Intent intent = new Intent(view.getContext(), AlbumDetailsActivity.class);
                    for(int i = 0; i < tracks.size(); i++){
                        if(tracks.get(i).getPosition() == position) intent.putExtra("track", tracks.get(i));
                    }
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    public RecyclerAdapter(ArrayList<Track> tracks){
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_recycler_item, parent, false);
        return new RecyclerViewHolder(v, tracks);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Track currentItem = tracks.get(position);

        holder.positionTextView.setText(String.valueOf(currentItem.getPosition()));
        Picasso.get().load(currentItem.getArtistPictureUrl()).resize(70,70).into(holder.artistImageView);
        holder.songTextView.setText(currentItem.getTrackName());
        holder.artistTextView.setText(currentItem.getArtistName());
        holder.durationTextView.setText(String.format(Locale.ENGLISH,"%02d:%02d", (currentItem.getDuration()/60), (currentItem.getDuration()%60)));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }
}
