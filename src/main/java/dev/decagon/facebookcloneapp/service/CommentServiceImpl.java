package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dao.CommentRepository;
import dev.decagon.facebookcloneapp.dao.CommentRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.CommentDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.Connection;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    final private  Connection connection;
    final private CommentRepository commentRepository;
    public CommentServiceImpl(Connection connection) {
        this.connection=connection;
        commentRepository=new CommentRepositoryImpl(connection);
    }

    @Override
    public Boolean save(CommentDTO commentDTO){
        return commentRepository.save(commentDTO);

    }
    @Override
    public List<User> likedAComment(Integer postId) {
        return null;
    }

    @Override
    public Boolean isLikedAComment(Integer userId, Integer commentId) {
        return null;
    }

    @Override
    public void like(Integer userId) {

    }

    @Override
    public void unlike(Integer userId, Integer commentId) {

    }

    @Override
    public List<Comment> postComments(Integer postId) {
        return commentRepository.postComments(postId);
    }
}
