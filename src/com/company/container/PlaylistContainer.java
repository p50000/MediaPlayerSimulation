package com.company.container;

import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;

public class PlaylistContainer {
    private ArrayList<Playlist> playlists;

    public PlaylistContainer() {
        fetchPlaylistsFromSystem();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlayList(ArrayList<MediaFile> mediaFiles){
        Playlist playlist = new Playlist(mediaFiles);
        playlists.add(playlist);
    }

    private void fetchPlaylistsFromSystem() {

    }

    public void Save() {

    }
}
