package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.dto.CommentDTO;
import dev.decagon.facebookcloneapp.model.Comment;

import java.util.List;

public interface CommentRepository <T,U,K>{
    T getById(K k);
    List<T> getAll();
    Boolean save(CommentDTO commentDTO);
    List<Comment> postComments(Integer postId);
    Comment update(CommentDTO comment,Integer commentId);
    Boolean delete(K k);
}
