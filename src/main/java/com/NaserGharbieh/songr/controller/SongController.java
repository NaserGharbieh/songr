package com.NaserGharbieh.songr.controller;

import com.NaserGharbieh.songr.models.Album;
import com.NaserGharbieh.songr.models.Song;
import com.NaserGharbieh.songr.repositores.AlbumRepository;
import com.NaserGharbieh.songr.repositores.SongRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/add-song")
    public RedirectView addSong(String title, int trackNumber, int length, Album songAtAlbum){
       Long albumId=songAtAlbum.getId();
        Album album =albumRepository.findById(albumId)
        .orElseThrow(() -> new IllegalArgumentException("Could not find album for this song in db!") );
        Song song =new Song(title,trackNumber,length,songAtAlbum);
        songRepository.save(song);
        return new RedirectView("/songs");
    }

    @GetMapping("/songs")
    public String getAlbums(Model m) {
        List<Song> songs =songRepository.findAll();

        m.addAttribute("songs", songs);

        return "songs.html"; // Corresponds to the HTML template
    }
}
