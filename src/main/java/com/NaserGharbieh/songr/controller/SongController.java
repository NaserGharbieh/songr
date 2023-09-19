package com.NaserGharbieh.songr.controller;

import com.NaserGharbieh.songr.exceptions.AlbumNotFoundException;
import com.NaserGharbieh.songr.models.Album;
import com.NaserGharbieh.songr.models.Song;
import com.NaserGharbieh.songr.repositores.AlbumRepository;
import com.NaserGharbieh.songr.repositores.SongRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @PostMapping("/add-song")
    public RedirectView addSong(String title, int trackNumber, int length , String albumTitle){


        Album album =albumRepository.findByTitle(albumTitle);
        if (album != null) {
            Song song = new Song(title, trackNumber, length, album);
            songRepository.save(song);
        }else {throw new AlbumNotFoundException("Could not find album for this song in db!)");}
        return new RedirectView("/songs");
    }

    @GetMapping("/songs")
    public String getAlbums(Model m) {
        List<Song> songs =songRepository.findAll();

        m.addAttribute("songs", songs);

        return "songs.html"; // Corresponds to the HTML template
    }
    @GetMapping("/album/{albumId}")
    public String viewAlbumDetails(@PathVariable Long albumId, Model model) {

        Optional<Album> albumOptional = albumRepository.findById(albumId);

        if (albumOptional.isPresent()) {
            Album album = albumOptional.get();
            model.addAttribute("album", album);
            return "album-details.html";
        } else {throw new AlbumNotFoundException("Could not find this album  in db!)");}
    }

}
