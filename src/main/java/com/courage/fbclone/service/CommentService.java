package com.courage.fbclone.service;

import dev.decagon.facebookcloneapp.model.User;

import java.util.List;

public interface CommentService {

    List<User> likedAComment(Integer postId);
    Boolean isLikedAComment(Integer userId,Integer commentId);
    void like(Integer userId);
    void unlike(Integer userId,Integer commentId);

}
