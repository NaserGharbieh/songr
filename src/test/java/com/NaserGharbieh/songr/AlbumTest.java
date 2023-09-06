package com.NaserGharbieh.songr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlbumTest {

    private Album album;

    @BeforeEach
    public void setUp() {
        // Create an instance of Album before each test
        album = new Album("Test Album", "Test Artist", 10, 300, "https://example.com/test.jpg");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Album", album.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Test Artist", album.getArtist());
    }

    @Test
    public void testGetSongCount() {
        assertEquals(10, album.getSongCount());
    }

    @Test
    public void testGetLength() {
        assertEquals(300, album.getLength());
    }

    @Test
    public void testGetImageUrl() {
        assertEquals("https://example.com/test.jpg", album.getImageUrl());
    }

    @Test
    public void testSetTitle() {
        album.setTitle("Updated Album Title");
        assertEquals("Updated Album Title", album.getTitle());
    }

    @Test
    public void testSetArtist() {
        album.setArtist("Updated Artist Name");
        assertEquals("Updated Artist Name", album.getArtist());
    }

    @Test
    public void testSetSongCount() {
        album.setSongCount(20);
        assertEquals(20, album.getSongCount());
    }

    @Test
    public void testSetLength() {
        album.setLength(450);
        assertEquals(450, album.getLength());
    }

    @Test
    public void testSetImageUrl() {
        album.setImageUrl("https://example.com/updated.jpg");
        assertEquals("https://example.com/updated.jpg", album.getImageUrl());
    }
}

