package com.example.Bcrypt.web;



import com.example.Bcrypt.Repositries.PostRepositories;
import com.example.Bcrypt.Repositries.UsersRepositories;
import com.example.Bcrypt.domain.Post;
import com.example.Bcrypt.domain.Users;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class userController {

    private  final UsersRepositories usersRepositories;
    private  final PostRepositories postRepositories;

    public userController(UsersRepositories usersRepositories, PostRepositories postRepositories) {
        this.usersRepositories = usersRepositories;
        this.postRepositories = postRepositories;
    }

    @GetMapping("/")
    public String hello(){
        return "index";
    }

    //creating new user
    @GetMapping("/newuser")
    public String addUser(){
        return "signUp";
    }

    @PostMapping("/signup")
    public RedirectView addNewUser(@ModelAttribute Users users){
        String hashedPassword= BCrypt.hashpw(users.getPassword(),BCrypt.gensalt(12));
        users.setPassword(hashedPassword);
        usersRepositories.save(users);
        return new RedirectView("/login");
    }

    //login user
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public RedirectView validateUser(@ModelAttribute Users users){
        Users dbUser=usersRepositories.findByuserName(users.getUserName());

        if ((dbUser == null) || (!BCrypt.checkpw(users.getPassword(), dbUser.getPassword()))) {
            return new RedirectView("/login");
        }
        return new RedirectView("post");
    }

    // post page
    @GetMapping("/post")
    public String addPost(Model model){
        model.addAttribute("users" , usersRepositories.findAll());
        model.addAttribute("allPosts",postRepositories.findAll());
        return "post";
    }

    @PostMapping("/post")
    public RedirectView postNewPost(@ModelAttribute Post post){
        postRepositories.save(post);

        return new RedirectView("post");

    }

}
