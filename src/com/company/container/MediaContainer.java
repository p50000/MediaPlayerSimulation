package com.company.container;

import com.company.MediaPlayerApplication;
import com.company.models.Audio;
import com.company.models.MediaFile;
import com.company.models.Video;

import java.time.Duration;
import java.util.ArrayList;

public class MediaContainer {
    private ArrayList<MediaFile> media;

    private MediaContainer() {}

    public MediaContainer(MediaPlayerApplication.key any) throws Exception {
        if(any == null) throw new Exception();
        media = new ArrayList<>();
        fetchMediaFromSystem();
    }

    public ArrayList<MediaFile> getMedia() {
        return media;
    }

    public void createMedia(MediaFile mediaFile){
        media.add(mediaFile);
    }

    public void fetchMediaFromSystem(){
        //here we load media data from user's system. for now it's simulated by creating media objects
        media.add(new Audio(Duration.ofMinutes(3), "Rick Astley - Never Gonna Give You Up", 0));
        media.add(new Audio(Duration.ofMinutes(6), "Blinding Lights", 1));
        media.add(new Audio(Duration.ofMinutes(2), "You should be sad", 2));
        media.add(new Audio(Duration.ofMinutes(3), "Imported", 3));
        media.add(new Audio(Duration.ofMinutes(1), "Slide", 4));
        media.add(new Audio(Duration.ofMinutes(2), "Sunday Best", 5));
        media.add(new Audio(Duration.ofMinutes(7), "Maniac", 6));
        media.add(new Video(Duration.ofHours(2), "Harry Potter", 7));
        media.add(new Video(Duration.ofMinutes(10), "Best Cat Memes Ever", 8));
    }
}
