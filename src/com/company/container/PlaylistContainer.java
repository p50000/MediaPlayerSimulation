package com.company.container;

import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;

public class PlaylistContainer {
    private ArrayList<Playlist> playlists;

    public void Save() {

    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlayList(ArrayList<MediaFile> mediaFiles){
        Playlist playlist = new Playlist();
        playlist.createPlaylist(mediaFiles);
        playlists.add(playlist);
    }
}
