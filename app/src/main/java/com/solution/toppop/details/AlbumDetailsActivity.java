package com.solution.toppop.details;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.solution.toppop.R;
import com.solution.toppop.api.AlbumDTO;
import com.solution.toppop.api.DeezerApiClient;
import com.solution.toppop.main.RecyclerAdapter;
import com.solution.toppop.main.Track;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumDetailsActivity extends AppCompatActivity {

    Track track;
    Album album;
    DeezerApiClient deezerApiClient;
    ImageView albumImageView;
    TextView artistTextView;
    TextView albumTextView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        Intent intent = getIntent();
        track = (Track)intent.getSerializableExtra("track");
        albumImageView = findViewById(R.id.albumImageView);
        albumTextView = findViewById(R.id.albumTextView);
        artistTextView = findViewById(R.id.artistTextView);

        Picasso.get().load(track.getAlbumPictureUrl()).into(albumImageView);
        albumTextView.setText(track.getAlbumName());
        artistTextView.setText(track.getArtistName());

        recyclerView = findViewById(R.id.tracksRecyclerView);
        deezerApiClient = new DeezerApiClient(this);
        deezerApiClient.getAlbum(track.getAlbumId());

    }

    public void processResponse(AlbumDTO response){
        ArrayList<AlbumTrack> albumTracks = new ArrayList<>();
        for(int i = 0; i < response.getTrack().getData().size(); i++){
            albumTracks.add(new AlbumTrack(
                    response.getTrack().getData().get(i).getTrackId(),
                    response.getTrack().getData().get(i).getTitle(),
                    response.getTrack().getData().get(i).getDuration()));
        }
        album = new Album(
                response.getId(),
                response.getAlbumTitle(),
                albumTracks
        );
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new AlbumDetailsRecyclerAdapter(albumTracks);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
