package com.company.externalservices;

import com.company.models.Audio;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class SpotifyManager implements MediaStreamingServiceManager {
    private ArrayList<Audio> songsAtServer;
    private static final int PLAYLIST_SIZE = 5;

    public SpotifyManager() {
        songsAtServer = new ArrayList<>();
        songsAtServer.add(new Audio(Duration.ofMinutes(3), "Rick Astley - Never Gonna Give You Up", 0));
        songsAtServer.add(new Audio(Duration.ofMinutes(6), "Lana Del Rey - Blue Jeans", 1));
        songsAtServer.add(new Audio(Duration.ofMinutes(2), "Lizzo - Soulmate", 2));
        songsAtServer.add(new Audio(Duration.ofMinutes(3), "Pink Floyd - In the flesh", 3));
        songsAtServer.add(new Audio(Duration.ofMinutes(1), "Metric - Dressed to suppress", 4));
        songsAtServer.add(new Audio(Duration.ofMinutes(2), "Coldplay - The Scientist", 5));
        songsAtServer.add(new Audio(Duration.ofMinutes(7), "Baby shark", 6));
    }

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
