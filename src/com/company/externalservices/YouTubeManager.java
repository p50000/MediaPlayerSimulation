package com.company.externalservices;

import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.models.Video;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class YouTubeManager implements MediaStreamingServiceManager {
    private ArrayList<Video> videosAtServer;
    private static final int PLAYLIST_SIZE = 10;

    public YouTubeManager() {
        videosAtServer = new ArrayList<>();
        videosAtServer.add(new Video(Duration.ofMinutes(2), "Cat Tries To Eat Potato, Fails", 0));
        videosAtServer.add(new Video(Duration.ofMinutes(10), "PewDiePie - Meme Review", 1));
        videosAtServer.add(new Video(Duration.ofMinutes(13), "New M1 Pro chip benchmark comparison", 2));
        videosAtServer.add(new Video(Duration.ofMinutes(30), "Music for studying compilation", 3));
        videosAtServer.add(new Video(Duration.ofMinutes(25), "Ducktales - full episode - best children cartoons", 4));
        videosAtServer.add(new Video(Duration.ofHours(10), "Rick Astley - Never gonna give you up - 10 hour loop rickroll", 5));
    }

    //supposedly makes a request to external server and loads media from it. for now dummy implementation
    private ArrayList<Video> fetchDataFromServer() {
        return videosAtServer;
    }

    //supposedly makes a request to external server and loads a single media file from it. for now dummy implementation
    private Video findDataFromServerByName(String request) {
        Video videoResponse = null;
        for (var video: videosAtServer) {
            if (video.getName().contains(request)) {
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
