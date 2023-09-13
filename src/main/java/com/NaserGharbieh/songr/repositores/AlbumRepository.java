package com.NaserGharbieh.songr.repositores;

import com.NaserGharbieh.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {

}
