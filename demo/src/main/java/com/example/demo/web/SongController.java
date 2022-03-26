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

    @ResponseBody
    @GetMapping("/allSongs")
    public List<Song> gitAllSongs(){
        return songRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/albumsSong/{id}")
    public List<Song> gitAllSongsByAlbum(@PathVariable int id){

        return songRepository.findByAlbumId(id);
    }

    @ResponseBody
    @GetMapping("/oneAlbums/{id}")
    public List<Album> gitAlbum(@PathVariable int id){

        return Collections.singletonList(albumRepository.findById(id).orElseThrow());
    }





}
