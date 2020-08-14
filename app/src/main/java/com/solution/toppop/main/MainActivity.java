package com.solution.toppop.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.solution.toppop.R;
import com.solution.toppop.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Track> tracks = new ArrayList<>();
    DeezerApiClient deezerApiClient;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout swipeRefreshLayout;
    int sortType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateChart();
            }
        });
        deezerApiClient = new DeezerApiClient(this);
        deezerApiClient.getChart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.sortRanking:
                sortRanking();
                break;
            case R.id.sortDurAsc:
                sortDurationAsc();
                break;
            case R.id.sortDurDesc:
                sortDurationDesc();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void processResponse(ChartDTO response){
        for(int i = 0; i < response.getTrack().getData().size(); i++){
            Track track = new Track(
                    response.getTrack().getData().get(i).getPosition(),
                    response.getTrack().getData().get(i).getTitle(),
                    response.getTrack().getData().get(i).getDuration(),
                    response.getTrack().getData().get(i).getArtist().getName(),
                    response.getTrack().getData().get(i).getAlbum().getName(),
                    response.getTrack().getData().get(i).getArtist().getPictureURL(),
                    response.getTrack().getData().get(i).getAlbum().getPictureURL(),
                    response.getTrack().getData().get(i).getAlbum().getAlbumId()
            );
            tracks.add(track);
        }

        switch(sortType){
            case 0:
                Collections.sort(tracks, new Comparator<Track>() {
                    @Override
                    public int compare(Track track1, Track track2) {
                        return track1.getPosition()-track2.getPosition();
                    }
                });
                break;
            case 1:
                Collections.sort(tracks, new Comparator<Track>() {
                    @Override
                    public int compare(Track track1, Track track2) {
                        return track1.getDuration()-track2.getDuration();
                    }
                });
                break;
            case 2:
                Collections.sort(tracks, new Comparator<Track>() {
                    @Override
                    public int compare(Track track1, Track track2) {
                        return track2.getDuration()-track1.getDuration();
                    }
                });
                break;
            default:
                break;
        }

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(tracks);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        if(swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public void updateChart(){
        tracks.clear();
        adapter.notifyDataSetChanged();
        deezerApiClient.getChart();
    }

    public void sortRanking(){
        Collections.sort(tracks, new Comparator<Track>() {
            @Override
            public int compare(Track track1, Track track2) {
                return track1.getPosition()-track2.getPosition();
            }
        });
        adapter.notifyDataSetChanged();
        sortType = 0;
    }

    public void sortDurationAsc(){
        Collections.sort(tracks, new Comparator<Track>() {
            @Override
            public int compare(Track track1, Track track2) {
                return track1.getDuration()-track2.getDuration();
            }
        });
        adapter.notifyDataSetChanged();
        sortType = 1;
    }

    public void sortDurationDesc(){
        Collections.sort(tracks, new Comparator<Track>() {
            @Override
            public int compare(Track track1, Track track2) {
                return track2.getDuration()-track1.getDuration();
            }
        });
        adapter.notifyDataSetChanged();
        sortType = 2;
    }
}
