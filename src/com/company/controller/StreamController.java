package com.company.controller;

import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.time.Duration;

public class StreamController {
    private Playlist currentPlaylist;
    private MediaFile currentMediaFile;
    private int MediaId;
    private Duration currentMoment;

    public Duration getCurrentMoment() {
        return currentMoment;
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public MediaFile getCurrentMediaFile() {
        return currentMediaFile;
    }

    public boolean switchMedia(){
        if(MediaId + 1 < currentPlaylist.size()){
            currentMediaFile = currentPlaylist.get(MediaId + 1);
            return true;
        }
        return false;
    }
    public boolean forward(Duration time){
        return false;
    }
    public boolean back(Duration time){
        return false;
    }
    public void playMedia(Playlist newPlaylist){
        currentPlaylist = newPlaylist;
        currentMediaFile = currentPlaylist.get(0);
    }
}
