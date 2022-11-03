package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Post;

public interface PostService {
    Post save(PostDTO post);

    void unlikeAPost(Integer userId,Integer postId);
    Integer like(Integer userId,Integer postId);

}
