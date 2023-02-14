package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.User;

import java.util.List;

public class ShowPostDTO {

    private Long id;
    private String username;

    private String content;

    private String mood;

    private List<User> userLikes;

    public ShowPostDTO() {
    }

    public String getUsername() {
        return username;
    }

    public ShowPostDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ShowPostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getMood() {
        return mood;
    }

    public ShowPostDTO setMood(String mood) {
        this.mood = mood;
        return this;
    }


    public Long getId() {
        return id;
    }

    public ShowPostDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public ShowPostDTO setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
        return this;
    }

    public boolean checkIfUserLiked(Long id) {
        return this.userLikes.stream().anyMatch(user -> user.getId().equals(id));
    }
}
