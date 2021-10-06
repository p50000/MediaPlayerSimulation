package com.company.models;


import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {
    private String playlistName;
    private ArrayList<MediaFile> mediaContent;

    public String getName(){
        return this.playlistName;
    }
    public void setName(String newName){
        this.playlistName = newName;
    }

    public String toString(){
        String result = "{'playlistName': '" + playlistName + "', 'mediaContent': [";
        for(int i=0;i<mediaContent.size();i++){
            result = result.concat(mediaContent.get(i).toString());
            if(i + 1 != mediaContent.size()){
                result = result.concat(", ");
            }
        }
        result = result.concat("]}");
        return result;
    }

    public Playlist() {
        this.mediaContent = new ArrayList<MediaFile>();
    }
    public Playlist(String dataString) {
        int startDataId = -1;
        int endDataId = -1;
        for(int i=1;i<dataString.length()-1;i++){

        }
    }

    void createPlaylist(ArrayList<MediaFile> tracks){
        this.mediaContent = tracks;
    }

    void addSong(MediaFile track){
        mediaContent.add(track);
    }

    void sortSongs(ArrayList<Integer> orderedMediaIds){
        ArrayList<MediaFile> newMediaContent = new ArrayList<MediaFile>();
        for (Integer orderedMediaId : orderedMediaIds) {
            newMediaContent.add(this.mediaContent.get(orderedMediaId));
        }
        this.mediaContent = newMediaContent;
    }
}