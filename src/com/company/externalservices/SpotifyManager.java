package com.company.externalservices;

import com.company.models.Audio;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;
import java.util.Collections;

public class SpotifyManager implements MediaStreamingServiceManager {
    ArrayList<Audio> songsAtServer;
    private static final int PLAYLIST_SIZE = 5;

    //supposedly makes a request to external server and loads media from it. for now dummy implementation
    private ArrayList<Audio> fetchDataFromServer() {
        return songsAtServer;
    }

    //supposedly makes a request to external server and loads a single media file from it. for now dummy implementation
    private Audio findDataFromServerByName(String request) {
        Audio songResponse = null;
        for (var song: songsAtServer) {
            if (song.getName().equals(request)) {
                songResponse = song;
            }
        }
        return songResponse;
    }

    @Override
    public Playlist getPlaylistOfDay() {
        Playlist playlistOfTheDay = new Playlist();
        ArrayList<Audio> availableSongs = fetchDataFromServer();

        Collections.shuffle(availableSongs);
        while(playlistOfTheDay.size() < PLAYLIST_SIZE) {
            int sz = playlistOfTheDay.getSize() ;
            playlistOfTheDay.addMedia(availableSongs.get(sz));
        }
        return playlistOfTheDay;
    }

    @Override
    public MediaFile getMediaByName(String name) {
        return findDataFromServerByName(name);
    }
}
