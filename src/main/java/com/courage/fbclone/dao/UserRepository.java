package com.courage.fbclone.dao;

import com.courage.fbclone.model.Comment;
import com.courage.fbclone.model.Post;
import com.courage.fbclone.model.User;


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
