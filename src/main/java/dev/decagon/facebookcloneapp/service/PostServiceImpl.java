package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dao.PostRepository;
import dev.decagon.facebookcloneapp.dao.PostRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.Post;

import java.sql.Connection;
import java.util.List;

public class PostServiceImpl implements PostService {
    Connection connection;
    PostRepository postRepository;

    public PostServiceImpl(Connection connection) {
        this.connection = connection;
        postRepository=new PostRepositoryImpl(connection);
    }

    @Override
    public Boolean save(PostDTO post) {
        return postRepository.save(post);

    }

    @Override
    public List<Post> getAllPosts() {

        return postRepository.getAll();

    }


    @Override
    public void unlikeAPost(Integer userId, Integer postId) {
        postRepository.unlike(postId);
    }

    @Override
    public Integer like(Integer userId, Integer postId) {
        return postRepository.getPostlike(postId);
    }

    @Override
    public List<Comment> getCommentsByPostById(Integer postId) {
        return postRepository.getCommentsByPostId(postId);

    }


}

