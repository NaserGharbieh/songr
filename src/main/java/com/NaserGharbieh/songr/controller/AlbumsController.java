package com.NaserGharbieh.songr.controller;

import com.NaserGharbieh.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumsController {
    @GetMapping("/albums")
    public String displayAlbums(Model model) {
        Album[] albums = new Album[3];
        albums[0] = new Album("Salute To Al-Ghor", "Ayloul | أيلول", 9, 2490, "https://cdns-images.dzcdn.net/images/cover/19b76b9b0f0cdd443f236c211aef412d/500x500.jpg");
        albums[1] = new Album("The Eminem Show", "Eminem", 38, 4620, "https://upload.wikimedia.org/wikipedia/en/3/35/The_Eminem_Show.jpg");
        albums[2] = new Album("Thriller", "Michael Jackson", 9, 2580, "https://s7d2.scene7.com/is/image/TWCNews/thrilleranniversarypng?wid=1250&hei=703&$wide-bg$");

        model.addAttribute("albums", albums);

        return "albums.html"; // Corresponds to the HTML template
    }


}