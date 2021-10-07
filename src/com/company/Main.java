package com.company;

import com.company.models.MediaFile;
import com.company.models.Playlist;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String formatDuration(Duration d) {
        long s = d.getSeconds();
        return String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
    }

    public static void showPlaylists(){
        List<Playlist> playlists = MediaPlayerApplication.getInstance().getAllPlaylists();
        System.out.println("Number of PlayLists (" + playlists.size() + ") : ");
        for(int i=1;i<=playlists.size();i++){
            System.out.println(i + ") " + playlists.get(i).getName() + " (Size :" + playlists.get(i).size() + ")");
        }
    }

    public static void showCurrentMoment(){
        System.out.println("Time Moment : " + formatDuration(MediaPlayerApplication.getInstance().getCurrentMoment()));
    }

    public static void showCurrentPlaylist(){
        Playlist playlist = MediaPlayerApplication.getInstance().getCurrentPlaylist();
        System.out.println(playlist.getName() + " (Size :" + playlist.size() + ") : ");
        for(int i=1;i<=playlist.size();i++){
            System.out.println(i + ") " + playlist.get(i).getName() + " " + playlist.get(i).getDuration() + " ");
        }
    }

    public static void showCurrentMedia(){
        MediaFile file = MediaPlayerApplication.getInstance().getCurrentMedia();
        System.out.println(file.getName() + " " + file.getDuration() + " ");
    }

    public static void showMediaById(int id){
        MediaFile file = MediaPlayerApplication.getInstance().getAllMedia().get(id);
        System.out.println(file.getName() + " " + file.getDuration() + " ");
    }

    public static void showPlaylistById(int id){
        Playlist playlist = MediaPlayerApplication.getInstance().getAllPlaylists().get(id);
        System.out.println(playlist.getName() + " (Size :" + playlist.size() + ") : ");
        for(int i=1;i<=playlist.size();i++){
            System.out.println(i + ") " + playlist.get(i).getName() + " " + playlist.get(i).getDuration() + " ");
        }
    }

    public static void forward(Duration time){
        MediaPlayerApplication.getInstance().forward(time);
        showCurrentMoment();
    }

    public static void back(Duration time){
        MediaPlayerApplication.getInstance().back(time);
        showCurrentMoment();
    }
    public static void switchForward(){
        MediaPlayerApplication.getInstance().switchForward();
        showCurrentMedia();
    }
    public static void switchBackward(){
        MediaPlayerApplication.getInstance().switchBackward();
        showCurrentMedia();
    }
    public static void playMediaById(int id){
        MediaPlayerApplication.getInstance().playMediaFile(id);
        showCurrentMedia();
    }
    public static void playPlaylistById(int id){
        MediaPlayerApplication.getInstance().playPlaylist(id);
        showCurrentMedia();
        Playlist playlist = MediaPlayerApplication.getInstance().getCurrentPlaylist();
        System.out.println(playlist.getName() + " (Size :" + playlist.size() + ") : ");
    }
    public static void sortSongs(Scanner input){

    }
    public static void createPlaylist(Scanner input){
        ArrayList<Integer> mediaIds = new ArrayList<>();
        MediaPlayerApplication mediaPlayerApplication = MediaPlayerApplication.getInstance();
        mediaPlayerApplication.createPlaylist(mediaIds);
        String playListName = input.nextLine();

    }
    public static void createMedia(Scanner input){

    }

    public static void main(String[] args) {
        Duration duration = Duration.ofSeconds(33);
        Scanner input= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter first number- ");
        while(true){
            switch (input.nextLine()){
                case "exit":
                    return;
                case "showPlaylists":
                    showPlaylists();
                case "showCurrentMoment":
                    showCurrentMoment();
                case "showCurrentPlaylist":
                    showCurrentPlaylist();
                case "show_current_media":
                    showCurrentMedia();
                case "showMediaById":
                    System.out.print("Id : ");
                    showMediaById(input.nextInt());
                case "showPlaylistById":
                    System.out.print("Id : ");
                    showPlaylistById(input.nextInt());
                case "forward":
                    System.out.print("Seconds : ");
                    forward(Duration.ofSeconds(input.nextInt()));
                case "back":
                    System.out.print("Seconds : ");
                    back(Duration.ofSeconds(input.nextInt()));
                case "switch_forward":
                    switchForward();
                case "switchBackward":
                    switchBackward();
                case "play_media_by_id":
                    System.out.print("Id : ");
                    playMediaById(input.nextInt());
                case "playPlaylistById":
                    System.out.print("Id : ");
                    playPlaylistById(input.nextInt());
                case "sortSongs":
                    sortSongs(input);
                case "createPlaylist":
                    System.out.println();
            }
        }
    }
}
