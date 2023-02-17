package com.likebookapp.service;

import com.likebookapp.model.dtos.AddPostDTO;
import com.likebookapp.model.dtos.ShowPostDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;
    private LoggedUser loggedUser;
    private UserRepository userRepository;

    private MoodRepository moodRepository;

    public PostService(PostRepository postRepository, LoggedUser loggedUser, UserRepository userRepository, MoodRepository moodRepository) {
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
    }

    public boolean addPost(AddPostDTO addPostDTO) {
        Optional<User> optUser = this.userRepository.findByUsername(loggedUser.getUsername());
        User user = optUser.get();

        Optional<Mood> optMood = this.moodRepository.findByMoodName(addPostDTO.getMood());
        Mood mood = optMood.get();

        Post post = new Post();
        post.setContent(addPostDTO.getContent());
        post.setMood(mood);
        post.setUser(user);
        post.setUserLikes(new HashSet<>());

        this.postRepository.save(post);
        return true;
    }

    public List<ShowPostDTO> findPostsByCurrentUser() {
        return this.postRepository.findByUserId(this.loggedUser.getId()).stream().map(this::mapPostToDTO).collect(Collectors.toList());
    }

    public List<ShowPostDTO> findAllOtherPosts() {
        return this.postRepository.findByUserIdNot(this.loggedUser.getId()).stream().
                map(this::mapPostToDTO).collect(Collectors.toList());
    }

    public ShowPostDTO mapPostToDTO(Post post) {
        ShowPostDTO showPostDTO = new ShowPostDTO();
        showPostDTO.setId(post.getId());
        showPostDTO.setContent(post.getContent());
        showPostDTO.setMood(post.getMood().getMoodName().name());
        showPostDTO.setUserLikes(new ArrayList<>(post.getUserLikes()));
        showPostDTO.setUsername(post.getUser().getUsername());

        return showPostDTO;
    }

    public void likePost(Long postId, Long userId) {
        Optional<Post> optPost = this.postRepository.findById(postId);
        Post post = optPost.get();


        Optional<User> optUser = this.userRepository.findById(userId);
        User user = optUser.get();

        post.getUserLikes().add(user);

        this.postRepository.save(post);

    }

    public void removePost(Long id) {
        this.postRepository.deleteById(id);
    }
}
