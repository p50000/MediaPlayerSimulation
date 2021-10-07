package com.company.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {
    private String playlistName;
    private ArrayList<MediaFile> mediaContent;

    public String getName() {
        return this.playlistName;
    }

    public void setName(String newName) {
        this.playlistName = newName;
    }

    public String toString() {
        String result = "{'playlistName': '" + playlistName + "', 'mediaContent': [";
        for (int i = 0; i < mediaContent.size(); i++) {
            result = result.concat(mediaContent.get(i).toString());
            if (i + 1 != mediaContent.size()) {
                result = result.concat(", ");
            }
        }
        result = result.concat("]}");
        return result;
    }

    public Playlist() {
        this.mediaContent = new ArrayList<MediaFile>();
    }

    public Playlist(String name, ArrayList<MediaFile> tracks) {
        this.playlistName = name;
        this.mediaContent = tracks;
    }

    public void addMedia(MediaFile track) {
        mediaContent.add(track);
    }

    public void sortMedia(List<Integer> orderedMediaIds) {
        ArrayList<MediaFile> newMediaContent = new ArrayList<MediaFile>();
        for (Integer orderedMediaId : orderedMediaIds) {
            newMediaContent.add(this.mediaContent.get(orderedMediaId));
        }
        this.mediaContent = newMediaContent;
    }

    public int size() {
        return mediaContent.size();
    }

    public MediaFile get(int id) {
        return mediaContent.get(id);
    }
}