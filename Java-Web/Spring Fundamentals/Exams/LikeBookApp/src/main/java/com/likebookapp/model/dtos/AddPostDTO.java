package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.enums.MoodName;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddPostDTO {
    @Size(min = 2, max = 50)
    @NotNull(message = "Content must not be empty!")
    private String content;
    @NotNull
    private MoodName mood;

    public String getContent() {
        return content;
    }

    public AddPostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodName getMood() {
        return mood;
    }

    public AddPostDTO setMood(MoodName mood) {
        this.mood = mood;
        return this;
    }
}
