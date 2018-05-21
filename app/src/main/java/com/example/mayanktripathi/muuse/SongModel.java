package com.example.mayanktripathi.muuse;

/**
 * Created by mayanktripathi on 21/05/18.
 */

public class SongModel {

    public String songName, artistName, songUrl;

    public SongModel(String songName, String artistName, String songUrl) {
        this.songName = songName;
        this.artistName = artistName;
        this.songUrl = songUrl;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
