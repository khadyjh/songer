package com.example.demo.web;

import com.example.demo.Repositries.AlbumRepository;
import com.example.demo.Repositries.SongRepository;
import com.example.demo.domain.Album;
import com.example.demo.domain.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class SongController {

    /////////////////////////////////////////// lab 13 ///////////////////////////////////////////

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongController(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @GetMapping("/Songs")
    public String Add(Model model){
        model.addAttribute("allSong",songRepository.findAll());
        model.addAttribute("allAlbum",albumRepository.findAll());
        return "homeSong";
    }

    @PostMapping("/addSong")
    public RedirectView addingNewSong(
            @ModelAttribute Song song){
            songRepository.save(song);
        return new RedirectView("Songs");

    }


    @GetMapping("/allSongs")
    public String gitAllSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";
    }


    // find song by album id
    @GetMapping("/albumsSong/{id}")
    public String gitAllSongsByAlbum(@PathVariable int id, Model model){

        model.addAttribute("idSong",songRepository.findByAlbumId(id));
        return "idSong";
    }

    // get all data about one album

    @GetMapping("/oneAlbums/{id}")
    public String gitAlbum(@PathVariable int id , Model model){

        model.addAttribute("album",albumRepository.findById(id).orElseThrow() );
        return "album";
    }





}
