package com.company;

import com.company.controller.StreamController;
import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.servives.MediaService;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class MediaPlayerApplication {

    static MediaPlayerApplication instance;

    StreamController streamController;

    MediaService mediaService;

    public Playlist getCurrentPlaylist() {
        return streamController.getCurrentPlaylist();
    }

    public void createMedia(MediaFile mediaFile){
        mediaService.createMedia(mediaFile);
    }

    public static class key {
        private key() {
        }
    }

    private static final key Key = new key();

    private MediaPlayerApplication() {
        try {
            streamController = new StreamController(Key);
            mediaService = new MediaService(Key);
        } catch (Exception exception) {
            streamController = null;
            mediaService = null;
        }
    }

    public static MediaPlayerApplication getInstance() {
        if (instance == null) instance = new MediaPlayerApplication();
        return instance;
    }

    public List<MediaFile> getAllMedia() {
        return mediaService.getAllMedia();
    }

    public List<Playlist> getAllPlaylists() {
        return mediaService.getAllPlayLists();
    }

    public void sortSongs(int playlistId, List<Integer> orderedMediaIds) {
        mediaService.sortMedia(playlistId, orderedMediaIds);
    }

    public void createPlaylist(String playlistName, List<Integer> mediaIds) {
        mediaService.createPlayList(playlistName, mediaIds);
    }

    public void addMediaToAPlaylist(int playlistId, int mediaId) {
        mediaService.addMediaToPlaylist(playlistId, mediaId);
    }

    public void playMediaFile(int mediaId) {
        Playlist currentPlaylist = mediaService.getPlaylistForPlaying(Collections.singletonList(mediaId));
        streamController.playMedia(currentPlaylist);
    }

    public void playPlaylist(int playlistId) {
        streamController.playMedia(mediaService.getPlaylistById(playlistId));
    }

    public MediaFile getCurrentMedia() {
        return streamController.getCurrentMediaFile();
    }

    public Duration getCurrentMoment() {
        return streamController.getCurrentMoment();
    }

    public boolean forward(Duration time) {
        return streamController.forward(time);
    }

    public boolean back(Duration time) {
        return streamController.back(time);
    }

    public boolean switchForward() {
        return streamController.switchForward();
    }

    public boolean switchBackward() {
        return streamController.switchBackward();
    }
}
