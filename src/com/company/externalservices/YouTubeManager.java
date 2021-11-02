package com.company.externalservices;

import com.company.models.Audio;
import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.models.Video;

import java.util.ArrayList;
import java.util.Collections;

public class YouTubeManager implements MediaStreamingServiceManager {
    ArrayList<Video> videosAtServer;
    private static final int PLAYLIST_SIZE = 10;

    //supposedly makes a request to external server and loads media from it. for now dummy implementation
    private ArrayList<Video> fetchDataFromServer() {
        return videosAtServer;
    }

    //supposedly makes a request to external server and loads a single media file from it. for now dummy implementation
    private Video findDataFromServerByName(String request) {
        Video videoResponse = null;
        for (var video: videosAtServer) {
            if (video.getName().equals(request)) {
                videoResponse = video;
            }
        }
        return videoResponse;
    }

    @Override
    public Playlist getPlaylistOfDay() {
        Playlist playlistOfTheDay = new Playlist();
        ArrayList<Video> availableVideos = fetchDataFromServer();

        Collections.shuffle(availableVideos);
        while(playlistOfTheDay.size() < PLAYLIST_SIZE) {
            int sz = playlistOfTheDay.getSize() ;
            playlistOfTheDay.addMedia(availableVideos.get(sz));
        }
        return playlistOfTheDay;
    }

    @Override
    public MediaFile getMediaByName(String name) {
        return findDataFromServerByName(name);
    }
}
