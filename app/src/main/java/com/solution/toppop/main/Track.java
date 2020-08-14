package com.solution.toppop.main;

import java.io.Serializable;

public class Track implements Serializable {

    private int position = -1;
    private String trackName = null;
    private int duration = -1;
    private String artistName = null;
    private String albumName = null;
    private String artistPictureUrl = null;
    private String albumPictureUrl = null;
    private int albumId = -1;

    public Track(int position, String trackName, int duration, String artistName, String albumName, String artistPictureUrl, String albumPictureUrl, int albumId) {
        this.position = position;
        this.trackName = trackName;
        this.duration = duration;
        this.artistName = artistName;
        this.albumName = albumName;
        this.artistPictureUrl = artistPictureUrl;
        this.albumPictureUrl = albumPictureUrl;
        this.albumId = albumId;
    }

    public Track() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistPictureUrl() {
        return artistPictureUrl;
    }

    public void setArtistPictureUrl(String artistPictureUrl) {
        this.artistPictureUrl = artistPictureUrl;
    }

    public String getAlbumPictureUrl() {
        return albumPictureUrl;
    }

    public void setAlbumPictureUrl(String albumPictureUrl) {
        this.albumPictureUrl = albumPictureUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
