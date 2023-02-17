package com.likebookapp.controller;

import com.likebookapp.model.dtos.ShowPostDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.service.PostService;
import com.likebookapp.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private PostService postService;

    private LoggedUser loggedUser;

    public HomeController(PostService postService, LoggedUser loggedUser) {

        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        List<ShowPostDTO> posts = this.postService.findPostsByCurrentUser();
        List<ShowPostDTO> otherPosts = this.postService.findAllOtherPosts();


        model.addAttribute("userPosts", posts);
        model.addAttribute("otherPosts", otherPosts);
        model.addAttribute("userId", this.loggedUser.getId());


        return "home";
    }


    @GetMapping("/home/like-post/{id}")
    public String likePost(@PathVariable("id") Long id) {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        Long userId = this.loggedUser.getId();

        this.postService.likePost(id, userId);

        return "redirect:/home";

    }

    @GetMapping("/home/remove-post/{id}")
    public String removePost(@PathVariable("id") Long id) {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        this.postService.removePost(id);

        return "redirect:/home";
    }

}
