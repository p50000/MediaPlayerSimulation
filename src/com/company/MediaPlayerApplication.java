package com.company;

import com.company.controller.StreamController;
import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.servives.MediaService;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class MediaPlayerApplication {

    MediaPlayerApplication instance;

    StreamController streamController;

    MediaService mediaService;

    private MediaPlayerApplication() {
        streamController = new StreamController();
        mediaService = new MediaService();
    }

    public MediaPlayerApplication getInstance() {
        if (instance == null){
            instance = new MediaPlayerApplication();
        }
        return instance;
    }

    public List<MediaFile> getAllMedia() {
        return mediaService.getAllMedia();
    }

    public List<Playlist> getAllPlaylists() {
        return mediaService.getAllPlayLists();
    }

    public void sortSongs(int playlistId, List<Integer> orderedMediaIds) {
        mediaService.sortSongs(playlistId, orderedMediaIds);
    }

    public void createPlaylist(List<Integer> mediaIds) {
        mediaService.createPlayList(mediaIds);
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

}
