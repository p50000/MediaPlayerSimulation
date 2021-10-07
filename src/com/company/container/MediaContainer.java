package com.company.container;

import com.company.models.MediaFile;

import java.util.ArrayList;

public class MediaContainer {
    private ArrayList<MediaFile> media;

    public MediaContainer() {
        fetchMediaFromSystem();
    }

    public ArrayList<MediaFile> getMedia() {
        return media;
    }

    public void fetchMediaFromSystem(){
    }
}
