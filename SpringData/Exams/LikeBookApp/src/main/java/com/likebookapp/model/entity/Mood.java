package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MoodName moodName;

    private String description;

    @OneToMany(mappedBy = "mood")
    private Set<Post> posts;

    public Mood(MoodName name) {
        this.moodName = name;
    }

    public Mood () {}

    public Long getId() {
        return id;
    }

    public Mood setId(Long id) {
        this.id = id;
        return this;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public Mood setMoodName(MoodName moodName) {
        this.moodName = moodName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Mood setPosts(Set<Post> posts) {
        this.posts = posts;
        return this;
    }
}
