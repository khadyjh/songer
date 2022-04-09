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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class userController {

    private  final UsersRepositories usersRepositories;
    private  final PostRepositories postRepositories;

    public userController(UsersRepositories usersRepositories, PostRepositories postRepositories) {
        this.usersRepositories = usersRepositories;
        this.postRepositories = postRepositories;
    }

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("allPost" ,postRepositories.findAll());
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
    public RedirectView logInUserWithSecret(HttpServletRequest request, String userName, String password)
    {
        Users userFromDb = usersRepositories.findByuserName(userName);
        if ((userFromDb == null)
                || (!BCrypt.checkpw(password, userFromDb.getPassword())))
        {
            return new RedirectView("/login");
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", userName);

        return new RedirectView("/post");
    }

    // post page
    @GetMapping("/post")
    public String addPost(Model model,HttpServletRequest request){
        HttpSession session= request.getSession();
        String username=session.getAttribute("username").toString();
        Users users=usersRepositories.findByuserName(username);
        model.addAttribute("users" , usersRepositories.findAll());
        model.addAttribute("username",username);
        model.addAttribute("userPost",postRepositories.findByUserId(users.getId()));
        return "post";
    }

    @PostMapping("/post")
    public RedirectView postNewPost(@ModelAttribute Post post, HttpServletRequest request, Model model){
        HttpSession session= request.getSession();
        String username=session.getAttribute("username").toString();
        Users users=usersRepositories.findByuserName(username);
        post.setUser(users);
        postRepositories.save(post);

        return new RedirectView("post");

    }

    //logout
    @PostMapping("/logout")
    public RedirectView logout(HttpServletRequest request){
        HttpSession session= request.getSession();
        session.invalidate();


        return new RedirectView("/");
    }

}
