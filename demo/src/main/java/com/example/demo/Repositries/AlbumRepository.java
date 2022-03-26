package com.example.demo.Repositries;

import com.example.demo.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Integer> {
}
