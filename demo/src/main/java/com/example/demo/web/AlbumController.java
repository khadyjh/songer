package com.example.demo.web;

import com.example.demo.Repositries.AlbumRepository;

import com.example.demo.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class AlbumController {

    /////////////////////////////////////////// lab 12 ///////////////////////////////////////////
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/Albums")
    public String Add(Model model){
        return "home";
    }

    @GetMapping("/newAlbum")
    public String render(Model model){
        model.addAttribute("albums",albumRepository.findAll());
        return "albums";
    }

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute Album album){
        albumRepository.save(album);
        return new RedirectView("newAlbum");
    }

    @PostMapping("/detail")
    public String getDetail(@RequestParam int id , Model model){
        model.addAttribute("album",albumRepository.findById(id).orElseThrow());
        return "album";
    }

}