package com.company.servives;

import com.company.MediaPlayerApplication;
import com.company.container.MediaContainer;
import com.company.container.PlaylistContainer;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.util.ArrayList;
import java.util.List;

public class MediaService {
    private PlaylistContainer playlistContainer;
    private MediaContainer mediaContainer;

    public MediaService(MediaPlayerApplication.key key) throws Exception {
        playlistContainer = new PlaylistContainer(key);
        mediaContainer = new MediaContainer(key);
    }

    public ArrayList<MediaFile> getAllMedia() {
        return mediaContainer.getMedia();
    }

    public ArrayList<MediaFile> getMediaByIds(List<Integer> mediaIds) {
        ArrayList<MediaFile> result = new ArrayList<>();
        ArrayList<MediaFile> temp = getAllMedia();
        for (Integer id : mediaIds) {
            result.add(temp.get(id));
        }
        return result;
    }

    public ArrayList<Playlist> getAllPlayLists() {
        return playlistContainer.getPlaylists();
    }

    public Playlist getPlaylistById(int playlistId) {
        return playlistContainer.getPlaylists().get(playlistId);
    }

    public void sortMedia(int playListId, List<Integer> orderedMediaIds) {
        Playlist playlist = getAllPlayLists().get(playListId);
        playlist.sortMedia(orderedMediaIds);
    }

    public void createPlayList(String playlistName, List<Integer> mediaIds) {
        ArrayList<MediaFile> mediaFiles = getMediaByIds(mediaIds);
        playlistContainer.addPlayList(playlistName, mediaFiles);
        playlistContainer.save();
    }

    public void addMediaToPlaylist(int playlistId, int mediaId) {
        getAllPlayLists().get(playlistId).addMedia(getAllMedia().get(mediaId));
    }

    public Playlist getPlaylistForPlaying(List<Integer> mediaId) {
        return new Playlist("Currently playing", getMediaByIds(mediaId));
    }
}
