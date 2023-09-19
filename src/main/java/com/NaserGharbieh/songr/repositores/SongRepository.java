package com.NaserGharbieh.songr.repositores;

import com.NaserGharbieh.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {

}
