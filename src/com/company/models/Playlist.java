package com.company.models;


import java.util.ArrayList;

public class Playlist {
    private ArrayList<MediaFile> mediaContent;

    public Playlist() {
        this.mediaContent = new ArrayList<MediaFile>();
    }

    void createPlaylist(ArrayList<MediaFile> tracks){
        this.mediaContent = tracks;
    }

    void addSong(MediaFile track){
        mediaContent.add(track);
    }

    void sortSongs(){

    }
}

class MediaFile{}