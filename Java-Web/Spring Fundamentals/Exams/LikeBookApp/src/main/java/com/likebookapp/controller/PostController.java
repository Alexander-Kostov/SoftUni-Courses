package com.likebookapp.controller;

import com.likebookapp.model.dtos.AddPostDTO;
import com.likebookapp.service.PostService;
import com.likebookapp.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PostController{

    private PostService postService;

    private LoggedUser loggedUser;

    public PostController(PostService postService, LoggedUser loggedUser) {
        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("addPostDTO")
    public AddPostDTO addPostDTO(){
        return new AddPostDTO();
    }

    @GetMapping("post/add")
    public String addPost() {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        return "post-add";
    }

    @PostMapping("post/add")
    public String addPost(@Valid AddPostDTO addPostDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (!loggedUser.loggedIn()) {
            return "redirect:/";
        }

        if(bindingResult.hasErrors() || !this.postService.addPost(addPostDTO)) {
            redirectAttributes.addFlashAttribute("addPostDTO", addPostDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPostDTO", bindingResult);

            return "redirect:/post/add";
        }

        return "redirect:/home";
    }


}
