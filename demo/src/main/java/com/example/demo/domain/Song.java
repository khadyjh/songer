package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@JsonIgnoreProperties({"album"})
@Entity
public class Song {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private float length;
    private int trackNumber;

    public Song( String title, float length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    protected Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + trackNumber +
                '}';
    }

    @ManyToOne
    Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
