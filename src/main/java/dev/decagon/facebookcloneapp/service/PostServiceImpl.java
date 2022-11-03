package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dao.PostRepository;
import dev.decagon.facebookcloneapp.dao.PostRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Post;

import java.sql.Connection;

public class PostServiceImpl implements PostService {
    Connection connection;
    PostRepository postRepository;

    public PostServiceImpl(Connection connection) {
        this.connection = connection;
        postRepository=new PostRepositoryImpl(connection);
    }

    @Override
    public Post save(PostDTO post) {
        Post dbPost = new Post();

        if (postRepository.save(post)) {
            dbPost.setUserId(post.getUserId());
            dbPost.setTextBody(post.getTextBody());
            dbPost.setId(dbPost.getId());
            dbPost.setLikes(post.getLikes());
        }
        return dbPost;
    }


    @Override
    public void unlikeAPost(Integer userId, Integer postId) {
        postRepository.unlike(postId);
    }

    @Override
    public Integer like(Integer userId, Integer postId) {
        return postRepository.getPostlike(postId);
    }

}

