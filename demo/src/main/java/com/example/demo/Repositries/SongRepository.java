package com.example.demo.Repositries;

import com.example.demo.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Integer> {
    List<Song> findByAlbumId(int id);
}
