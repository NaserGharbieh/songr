package com.NaserGharbieh.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "song_title",nullable = false)
    private  String title;
    @Column(name = "song_Number",nullable = false)
    private  int trackNumber;
    @Column(name = "song_length",nullable = false)
    private int length ;
    @ManyToOne
   private Album songAtAlbum;
    public Song(){}
    public Song(String title, int trackNumber, int length, Album songAtAlbum) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.length = length;
        this.songAtAlbum = songAtAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Album getSongAtAlbum() {
        return songAtAlbum;
    }

    public void setSongAtAlbum(Album songAtAlbum) {
        this.songAtAlbum = songAtAlbum;
    }
}
