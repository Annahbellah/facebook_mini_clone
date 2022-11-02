package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.model.User;

import java.util.List;

public interface UserRepository<T extends User,U,K>{
    User getById(K k);
    List<T> getAll();
    T save(U u);
    T update(U u, K k);
    Boolean delete(K k);
    List<Comment> getUserComments(Integer userId);
    List<Post> getUserPosts(Integer userId);
}
