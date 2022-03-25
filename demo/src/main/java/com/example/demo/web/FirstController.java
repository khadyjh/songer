package com.example.demo.web;

import com.example.demo.domain.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {

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


    @ResponseBody
    @GetMapping("/albums")
    List<Album> getAlbum(){
        List<Album> albums=new ArrayList<>();
        albums.add(new Album("title","hamzah namira",5,"www.newone.com",120.5f));
        albums.add(new Album("title1","hmoud alkhader",6,"www.one.com",130.5f));
        albums.add(new Album("title2","maher zain",8,"www.new.com",150.5f));

        return albums;
    }
}
