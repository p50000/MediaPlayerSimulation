package com.company;

import com.company.models.MediaFile;

import java.time.Duration;
import java.util.List;

public class Main {

    private static String formatDuration(Duration d) {
        long s = d.toSeconds();
        return String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
    }

    public static void main(String[] args) {
        Duration duration = Duration.ofSeconds(33);
        MediaPlayerApplication player = MediaPlayerApplication.getInstance();

        List<MediaFile> AvailableMusic = player.getAllMedia();

        for (int i = 0; i < AvailableMusic.size(); i++) {
            MediaFile temp = AvailableMusic.get(i);
            System.out.printf("Name: %s, duration: %s, id: %d, format: %s\n",
                    temp.getName(), formatDuration(temp.getDuration()), temp.getId(), temp.getFormat().toString());
        }
        player.createPlaylist("My playlist", List.of(0, 2));
        player.playPlaylist(0);
        System.out.printf("Now playing: %s\n", player.getCurrentMedia().getName());
        // Now playing: Rick Astley - Never Gonna Give You Up
        System.out.printf("Moment playing: %s\n", formatDuration(player.getCurrentMoment()));
        // Moment playing: 0:00:00

        player.addMediaToAPlaylist(0, 5);
        player.sortSongs(0, List.of(2, 0, 1));
        player.playPlaylist(0);
        player.forward(Duration.ofSeconds(20));
        System.out.printf("Now playing: %s\n", player.getCurrentMedia().getName());
        // Now playing: Sunday Best
        System.out.printf("Moment playing: %s\n", formatDuration(player.getCurrentMoment()));
        // Moment playing: 0:00:20
        player.back(Duration.ofSeconds(5));
        System.out.printf("Moment playing: %s\n", formatDuration(player.getCurrentMoment()));
        // Moment playing: 0:00:15

        player.switchForward();
        System.out.printf("Now playing: %s\n", player.getCurrentMedia().getName());
        // Now playing: Sunday Best
        player.forward(Duration.ofSeconds(81921830));
        System.out.printf("Now playing: %s\n", player.getCurrentMedia().getName());
        // Now playing: Rick Astley - Never Gonna Give You Up
        System.out.printf("Moment playing: %s\n", formatDuration(player.getCurrentMoment()));
        // Moment playing: 0:00:00

        player.switchBackward();
        System.out.printf("Now playing: %s\n", player.getCurrentMedia().getName());
        // Now playing: Sunday Best
        System.out.printf("Moment playing: %s\n", formatDuration(player.getCurrentMoment()));
        // Moment playing: 0:00:00

    }
}
