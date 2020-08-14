package com.solution.toppop.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlbumDTO {

    public int id;
    @SerializedName("title")
    public String albumTitle;
    public Track tracks;

    public Track getTrack() {
        return tracks;
    }

    public int getId() {
        return id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setTrack(Track tracks) {
        this.tracks = tracks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }


    public class Track {

        private ArrayList<Data> data;

        public ArrayList<Data> getData() {
            return data;
        }

        public void setData(ArrayList<Data> data) {
            this.data = data;
        }
    }


    public class Data{

        @SerializedName("id")
        private int trackId;
        private String title;
        private int duration;

        public int getTrackId() {
            return trackId;
        }

        public void setTrackId(int trackId) {
            this.trackId = trackId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

    }
}
