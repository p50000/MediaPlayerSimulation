package com.company;

import com.company.models.Audio;
import com.company.models.MediaFile;
import com.company.models.Playlist;
import com.company.models.Video;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String formatDuration(Duration d) {
        long s = d.getSeconds();
        return String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
    }

    public static void showPlaylists() {
        List<Playlist> playlists = MediaPlayerApplication.getInstance().getAllPlaylists();
        System.out.println("Number of PlayLists (" + playlists.size() + ") : ");
        for (int i = 1; i <= playlists.size(); i++) {
            System.out.println(i + ") " + playlists.get(i - 1).getName() + " (Size :" + playlists.get(i - 1).size() + ")");
        }
    }

    public static void showMedia() {
        List<MediaFile> playlists = MediaPlayerApplication.getInstance().getAllMedia();
        System.out.println("Number of Media (" + playlists.size() + ") : ");
        for (int i = 1; i <= playlists.size(); i++) {
            System.out.println(i + ") " + playlists.get(i - 1).getName() + " (" + playlists.get(i - 1).getDuration() + ")");
        }
    }

    public static void showCurrentMoment() {
        System.out.println("Time Moment : " + formatDuration(MediaPlayerApplication.getInstance().getCurrentMoment()));
    }

    public static void showCurrentPlaylist() {
        Playlist playlist = MediaPlayerApplication.getInstance().getCurrentPlaylist();
        if (playlist == null) {
            System.out.println("No playing playlist");
            return;
        }
        System.out.println(playlist.getName() + " (Size :" + playlist.size() + ") : ");
        for (int i = 1; i <= playlist.size(); i++) {
            System.out.println(i + ") " + playlist.get(i - 1).getName() + " " + playlist.get(i - 1).getDuration() + " ");
        }
    }

    public static void showCurrentMedia() {
        MediaFile file = MediaPlayerApplication.getInstance().getCurrentMedia();
        if (file == null) {
            System.out.println("No playing media");
            return;
        }
        System.out.println(file.getName() + " " + file.getDuration() + " ");
    }

    public static void showMediaById(int id) {
        if (MediaPlayerApplication.getInstance().getAllMedia().size() < id) {
            System.out.println("No media by id " + id);
            return;
        }
        MediaFile file = MediaPlayerApplication.getInstance().getAllMedia().get(id - 1);
        System.out.println(file.getName() + " " + file.getDuration() + " ");
    }

    public static void showPlaylistById(int id) {
        if (MediaPlayerApplication.getInstance().getAllPlaylists().size() < id) {
            System.out.println("No playlist by id " + id);
            return;
        }
        Playlist playlist = MediaPlayerApplication.getInstance().getAllPlaylists().get(id - 1);
        System.out.println(playlist.getName() + " (Size :" + playlist.size() + ") : ");
        for (int i = 1; i <= playlist.size(); i++) {
            System.out.println(i + ") " + playlist.get(i - 1).getName() + " " + playlist.get(i - 1).getDuration() + " ");
        }
    }

    public static void forward(Duration time) {
        MediaPlayerApplication.getInstance().forward(time);
        showCurrentMoment();
    }

    public static void back(Duration time) {
        MediaPlayerApplication.getInstance().back(time);
        showCurrentMoment();
    }

    public static void switchForward() {
        MediaPlayerApplication.getInstance().switchForward();
        showCurrentMedia();
    }

    public static void switchBackward() {
        MediaPlayerApplication.getInstance().switchBackward();
        showCurrentMedia();
    }

    public static void playMediaById(int id) {
        if (MediaPlayerApplication.getInstance().getAllMedia().size() < id) {
            System.out.println("No media by id " + id);
            return;
        }
        MediaPlayerApplication.getInstance().playMediaFile(id - 1);
        showCurrentMedia();
    }

    public static void playPlaylistById(int id) {
        if (MediaPlayerApplication.getInstance().getAllPlaylists().size() < id) {
            System.out.println("No playlist by id " + id);
            return;
        }
        MediaPlayerApplication.getInstance().playPlaylist(id - 1);
        showCurrentMedia();
        Playlist playlist = MediaPlayerApplication.getInstance().getCurrentPlaylist();
        System.out.println("Playlist : " + playlist.getName() + " (Size :" + playlist.size() + ")");
    }

    public static void sortSongs(Scanner input) {

    }

    public static void createPlaylist(String playListName) {
        ArrayList<Integer> mediaIds = new ArrayList<>();
        MediaPlayerApplication.getInstance().createPlaylist(playListName, mediaIds);
        System.out.println("PlayList " + playListName + " created.");
    }

    public static void createMedia(Scanner input) {
        System.out.print("Types (1 - Audio, 2 - Video) : ");
        int type = input.nextInt();
        input.nextLine();
        System.out.print("New Media name : ");
        String mediaName = input.nextLine();
        System.out.print("New Media Duration in seconds : ");
        Duration duration = Duration.ofSeconds(input.nextLong());
        input.nextLine();
        int id = MediaPlayerApplication.getInstance().getAllMedia().size();
        if (type == 1) {
            Audio mediaFile = new Audio(duration, mediaName, id);
            MediaPlayerApplication.getInstance().createMedia(mediaFile);
            System.out.println("Audio file created");
        } else {
            Video mediaFile = new Video(duration, mediaName, id);
            MediaPlayerApplication.getInstance().createMedia(mediaFile);
            System.out.println("Video file created");
        }
    }

    public static void addMediaToPlaylist(Scanner input) {
        System.out.print("Media Id : ");
        int mediaId = input.nextInt();
        input.nextLine();
        System.out.print("Playlist Id : ");
        int playlistId = input.nextInt();
        input.nextLine();
        if (MediaPlayerApplication.getInstance().getAllMedia().size() < mediaId) {
            System.out.println("No media by id " + mediaId);
            return;
        }
        if (MediaPlayerApplication.getInstance().getAllPlaylists().size() < playlistId) {
            System.out.println("No media by id " + playlistId);
            return;
        }
        MediaPlayerApplication.getInstance().addMediaToAPlaylist(playlistId - 1, mediaId - 1);
        System.out.println("Media file added to playlist");
    }

    public static void main(String[] args) {
        Duration duration = Duration.ofSeconds(33);
        Scanner input = new Scanner(System.in);    //System.in is a standard input stream
        while (true) {
            switch (input.nextLine()) {
                case "exit":
                    return;
                case "showMedia":
                    showMedia();
                    break;
                case "showPlaylists":
                    showPlaylists();
                    break;
                case "showCurrentMoment":
                    showCurrentMoment();
                    break;
                case "showCurrentPlaylist":
                    showCurrentPlaylist();
                    break;
                case "showCurrentMedia":
                    showCurrentMedia();
                    break;
                case "showMediaById":
                    System.out.print("Id : ");
                    showMediaById(input.nextInt());
                    input.nextLine();
                    break;
                case "showPlaylistById":
                    System.out.print("Id : ");
                    showPlaylistById(input.nextInt());
                    input.nextLine();
                    break;
                case "forward":
                    System.out.print("Seconds : ");
                    forward(Duration.ofSeconds(input.nextInt()));
                    input.nextLine();
                    break;
                case "back":
                    System.out.print("Seconds : ");
                    back(Duration.ofSeconds(input.nextInt()));
                    input.nextLine();
                    break;
                case "switchForward":
                    switchForward();
                    break;
                case "switchBackward":
                    switchBackward();
                    break;
                case "playMediaById":
                    System.out.print("Id : ");
                    playMediaById(input.nextInt());
                    input.nextLine();
                    break;
                case "playPlaylistById":
                    System.out.print("Id : ");
                    playPlaylistById(input.nextInt());
                    input.nextLine();
                    break;
                case "sortSongs":
                    sortSongs(input);
                case "createPlaylist":
                    System.out.print("New Playlist Name : ");
                    createPlaylist(input.nextLine());
                    break;
                case "createMedia":
                    createMedia(input);
                    break;
                case "addMediaToPlaylist":
                    addMediaToPlaylist(input);
                    break;
            }
        }
    }
}
