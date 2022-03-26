package com.example.demo.Repositries;

import com.example.demo.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
