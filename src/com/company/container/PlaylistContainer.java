package com.company.container;

import com.company.MediaPlayerApplication;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;

public class PlaylistContainer {
    private ArrayList<Playlist> playlists;

    public PlaylistContainer(MediaPlayerApplication.key any) throws Exception {
        if (any == null) {
            throw new Exception();
        }
        playlists = new ArrayList<>();
        fetchPlaylistsFromSystem();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlayList(String playlistName, ArrayList<MediaFile> mediaFiles) {
        Playlist playlist = new Playlist(playlistName, mediaFiles);
        playlists.add(playlist);
        save();
    }

    private void fetchPlaylistsFromSystem() {
        //here we upload playlists saved by user - for now dummy function
    }

    public void save() {
        //dummy function where we supposedly save all the current playlist data so it would not be lost
    }
}
