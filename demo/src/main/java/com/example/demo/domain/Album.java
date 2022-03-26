package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String artist;
    private int songCount;
    private String imgUrl;
    private float length;

    public Album(String title, String artist, int songCount, String imgUrl, float length) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.imgUrl = imgUrl;
        this.length = length;
    }

    protected Album() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", imgUrl='" + imgUrl + '\'' +
                ", length=" + length +
                '}';
    }

    @OneToMany(mappedBy = "album")
    List<Song> songs;
}
