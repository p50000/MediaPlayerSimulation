package com.company.container;

import com.company.MediaPlayerApplication;
import com.company.models.Audio;
import com.company.models.MediaFile;

import javax.xml.datatype.DatatypeFactory;
import java.time.Duration;
import java.util.ArrayList;

public class MediaContainer {
    private ArrayList<MediaFile> media;

    private MediaContainer(){}

    public MediaContainer(MediaPlayerApplication.key any) throws Exception {
        if(any == null) throw new Exception();
        media = new ArrayList<>();
        fetchMediaFromSystem();
    }

    public ArrayList<MediaFile> getMedia() {
        return media;
    }

    public void fetchMediaFromSystem(){
        //here we load media data from user's system. for now it's simulated by creating media objects
        media.add(new Audio(Duration.ofMinutes(3), "Rick Astley - Never Gonna Give You Up", 0));

    }
}
