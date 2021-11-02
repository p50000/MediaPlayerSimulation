package com.company.externalservices;

import com.company.models.MediaFile;
import com.company.models.Playlist;


public interface MediaStreamingServiceManager {
    Playlist getPlaylistOfDay();

    MediaFile getMediaByName(String name);
}