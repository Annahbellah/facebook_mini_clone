package com.courage.fbclone.service;

import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.util.List;

public interface PostService {
    List<User> likedAPost(Integer userId, Integer postId);
    Boolean isLikedAPost(Integer userId,Integer postId);
    void unlikeAPost(Integer userId,Integer postId);
    void like(Integer userId,Integer postId);
    List<Comment> comments(Integer postId);

}
