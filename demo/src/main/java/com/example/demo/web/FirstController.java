package com.example.demo.web;

import com.example.demo.Repositries.AlbumRepository;
import com.example.demo.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {

    /////////////////////////////////////////// lab 11 ///////////////////////////////////////////
    @GetMapping("/")
    String getRoot(){
        return "index";
    }

    @GetMapping("/hello")
    String hello(){
        System.out.println("hello");
        return "hello";
    }


    @GetMapping("/capitalize")
    String capital(@RequestParam(name = "name", required = false, defaultValue = "capitalize word ") String name,
                   Model model) {

        model.addAttribute("name", name.toUpperCase());


        return "cap";
    }

    @GetMapping("/cap/{name}")
    String cap(@PathVariable(name = "name",required = false) String word, Model model){
        model.addAttribute("name",word.toUpperCase());


        return "cap";
    }



    @GetMapping("/albumsBasic")
    String getAlbum(Model model){
        List<Album> albums=new ArrayList<>();
        albums.add(new Album("title","hamzah namira",5,"www.newone.com",120.5f));
        albums.add(new Album("title1","hmoud alkhader",6,"www.one.com",130.5f));
        albums.add(new Album("title2","maher zain",8,"www.new.com",150.5f));

        model.addAttribute("albums",albums);
        return "albumsBasic";
    }

}
