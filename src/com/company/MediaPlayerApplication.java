package com.company;

import com.company.controller.StreamController;
import com.company.externalservices.MediaStreamingServiceManager;
import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.services.MediaService;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class MediaPlayerApplication {

    private static MediaPlayerApplication instance;

    private StreamController streamController;

    private MediaService mediaService;

    private MediaStreamingServiceManager streamingServiceManager;

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

    public void createMedia(MediaFile mediaFile) {
        mediaService.createMedia(mediaFile);
    }

    public void addMediaFromServiceByName(String name) {
        if (streamingServiceManager == null) {
            System.out.println("You are not connected to any service");
            return;
        }
        MediaFile mediaFile = streamingServiceManager.getMediaByName(name);
        if (mediaFile == null) {
            System.out.println("No such media!");
            return;
        }
        mediaService.createMedia(mediaFile);
        System.out.println("Media item added!");
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

    public Playlist getCurrentPlaylist() {
        return streamController.getCurrentPlaylist();
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

    public void playPlayListOfTheDay() {
        if (streamingServiceManager == null) {
            System.out.println("You are not connected to any service");
            return;
        }
        Playlist playlistOfTheDay = streamingServiceManager.getPlaylistOfDay();
        playlistOfTheDay.setName("Playlist of the day");
        streamController.playMedia(playlistOfTheDay);
    }

    public void connectToNewService(MediaStreamingServiceManager serviceManager) {
        this.streamingServiceManager = serviceManager;
    }
}
