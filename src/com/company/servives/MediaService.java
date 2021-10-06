package com.company.servives;

import com.company.container.MediaContainer;
import com.company.container.PlaylistContainer;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;

public class MediaService {
    private PlaylistContainer playlistContainer;
    private MediaContainer mediaContainer;

    public ArrayList<MediaFile> getAllMedia(){
        return mediaContainer.getMedia();
    }
    public ArrayList<MediaFile> getMediaByIds(ArrayList<Integer> mediaIds){
        ArrayList<MediaFile> result = new ArrayList<>();
        ArrayList<MediaFile> temp = getAllMedia();
        for(Integer id: mediaIds){
            result.add(temp.get(id));
        }
        return result;
    }
    public ArrayList<Playlist> getAllPlayLists(){
        return playlistContainer.getPlaylists();
    }
    public void sortSongs(int playListId, ArrayList<Integer> orderedMediaIds){
        Playlist playlist = getAllPlayLists().get(playListId);
        playlist.sortSongs(orderedMediaIds);
    }
    public void createPlayList(ArrayList<Integer> mediaIds){
        ArrayList<MediaFile> mediaFiles = getMediaByIds(mediaIds);
        playlistContainer.addPlayList(mediaFiles);
    }
    public void addSongToPlaylist(int playlistId, int mediaId){
        getAllPlayLists().get(playlistId).addSong(getAllMedia().get(mediaId));
    }
    public Playlist getPlaylistForPlaying(int mediaId){
        Playlist playlist = new Playlist();
        playlist.addSong(getAllMedia().get(mediaId));
        return playlist;
    }
}
