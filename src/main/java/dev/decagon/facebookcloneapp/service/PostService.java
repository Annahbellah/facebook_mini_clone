package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Post;

import java.util.List;

public interface PostService {
    Boolean save(PostDTO post);
    List<Post>getAllPosts();

    void unlikeAPost(Integer userId,Integer postId);
    Integer like(Integer userId,Integer postId);

}
