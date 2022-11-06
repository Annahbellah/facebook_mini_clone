package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.Post;

import java.util.List;

public interface PostRepository<T,U,K>{
    Post getById(Integer postId);
    List<T> getAll();
    Boolean save(U u);
    Boolean update(String message, Integer postId);
    Boolean delete(K k);
    List<T> userPosts(K k);

    Integer getPostlike(Integer postId);

    Integer unlike(Integer postId);

    List<Comment> getCommentsByPostId(Integer postId);

    Integer likeAPost(Integer postId);
}
