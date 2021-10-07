package com.company.controller;

import com.company.MediaPlayerApplication;
import com.company.enums.StreamState;
import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.time.Duration;

import static com.company.enums.StreamState.IDLE;
import static com.company.enums.StreamState.PLAYING;

public class StreamController {

    private Playlist currentPlaylist;
    private MediaFile currentMediaFile;
    private StreamState streamState;
    private int mediaId;
    private Duration currentMoment;

    private StreamController() {
    }

    public StreamController(MediaPlayerApplication.key any) {
        if (any == null) return;
        currentMoment = Duration.ZERO;
        streamState = IDLE;
        mediaId = -1;
    }

    public Duration getCurrentMoment() {
        return currentMoment;
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public MediaFile getCurrentMediaFile() {
        return currentMediaFile;
    }

    public boolean switchForward() {
        if (streamState == IDLE) return false;
        if (mediaId + 1 < currentPlaylist.size()) {
            currentMediaFile = currentPlaylist.get(++mediaId);
            return true;
        }
        currentPlaylist = null;
        currentMediaFile = null;
        currentMoment = Duration.ZERO;
        mediaId = -1;
        streamState = IDLE;
        return false;
    }

    public boolean switchBackward() {
        if (streamState == IDLE) return false;
        if (mediaId > 0) {
            currentMediaFile = currentPlaylist.get(--mediaId);
            mediaId--;
            return true;
        }
        currentPlaylist = null;
        currentMediaFile = null;
        currentMoment = Duration.ZERO;
        mediaId = -1;
        streamState = IDLE;
        return false;
    }

    public boolean forward(Duration time) {
        if (streamState == IDLE) return false;
        Duration timeLeft = currentMediaFile.getDuration().minus(currentMoment);
        if (timeLeft.compareTo(time) < 0) {
            return switchForward();
        }
        currentMoment = currentMoment.plus(time);
        return true;
    }

    public boolean back(Duration time) {
        if (streamState == IDLE) return false;
        if (currentMoment.compareTo(time) < 0) {
            time = currentMoment;
            return true;
        }
        currentMoment = currentMoment.minus(time);
        return true;
    }

    public void playMedia(Playlist newPlaylist) {
        currentPlaylist = newPlaylist;
        currentMediaFile = currentPlaylist.get(0);
        currentMoment = Duration.ZERO;
        streamState = PLAYING;
    }

    public StreamState getStreamState() {
        return streamState;
    }

    public void setStreamState(StreamState streamState) {
        this.streamState = streamState;
    }
}
