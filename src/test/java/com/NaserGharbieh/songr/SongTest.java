package com.NaserGharbieh.songr;

import com.NaserGharbieh.songr.models.Album;
import com.NaserGharbieh.songr.models.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SongTest {

    @Test
    public void createSongObject() {
        Album album = new Album("Test Album", "Test Artist", 10, 300, "test-image.jpg");
        Song song = new Song("Test Song", 1, 180, album);

        assertNotNull(song);
    }

    @Test
    public void testSongGettersAndSetters() {
        Album album = new Album("Test Album", "Test Artist", 10, 300, "test-image.jpg");
        Song song = new Song();

        song.setTitle("Test Song");
        song.setTrackNumber(1);
        song.setLength(180);
        song.setSongAtAlbum(album);

        assertEquals("Test Song", song.getTitle());
        assertEquals(1, song.getTrackNumber());
        assertEquals(180, song.getLength());
        assertEquals(album, song.getSongAtAlbum());
    }

    @Test
    public void testSongAlbumRelationship() {
        Album album = new Album("Test Album", "Test Artist", 10, 300, "test-image.jpg");
        Song song = new Song("Test Song", 1, 180, album);

        assertNotNull(song.getSongAtAlbum());
        assertEquals("Test Album", song.getSongAtAlbum().getTitle());
        assertEquals("Test Artist", song.getSongAtAlbum().getArtist());
        assertEquals(10, song.getSongAtAlbum().getSongCount());
        assertEquals(300, song.getSongAtAlbum().getLength());
        assertEquals("test-image.jpg", song.getSongAtAlbum().getImageUrl());
    }
}

