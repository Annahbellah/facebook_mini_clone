package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.CommentDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.util.List;

public interface CommentService {

    List<User> likedAComment(Integer postId);
    Boolean isLikedAComment(Integer userId,Integer commentId);
    void like(Integer userId);
    void unlike(Integer userId,Integer commentId);

    List<Comment> postComments(Integer postId);

    Boolean save(CommentDTO build);
}
