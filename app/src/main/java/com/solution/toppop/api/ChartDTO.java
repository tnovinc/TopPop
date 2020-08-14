package com.solution.toppop.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChartDTO {

    public Track tracks;

    public Track getTrack() {
        return tracks;
    }

    public void setTrack(Track tracks) {
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

    public class Data {

        @SerializedName("id")
        private int trackId;
        private String title;
        private int duration;
        private int position;
        private Artist artist;
        private Album album;

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

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
        }

    }

    public class Artist {

        @SerializedName("id")
        private int artistId;
        private String name;
        @SerializedName("picture_medium")
        private String pictureURL;

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPictureURL() {
            return pictureURL;
        }

        public void setPictureURL(String pictureURL) {
            this.pictureURL = pictureURL;
        }
    }

    public class Album {

        @SerializedName("id")
        private int albumId;
        @SerializedName("title")
        private String name;
        @SerializedName("cover_medium")
        private String pictureURL;

        public int getAlbumId() {
            return albumId;
        }

        public void setAlbumId(int albumId) {
            this.albumId = albumId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPictureURL() {
            return pictureURL;
        }

        public void setPictureURL(String pictureURL) {
            this.pictureURL = pictureURL;
        }
    }
}
