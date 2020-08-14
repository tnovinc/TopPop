package com.solution.toppop.details;

import java.util.ArrayList;

public class Album {

    private int id;
    private String title;
    private ArrayList<AlbumTrack> tracks;

    public Album(int id, String title, ArrayList<AlbumTrack> tracks) {
        this.id = id;
        this.title = title;
        this.tracks = tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<AlbumTrack> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<AlbumTrack> tracks) {
        this.tracks = tracks;
    }
}
