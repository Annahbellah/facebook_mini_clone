package dev.decagon.facebookcloneapp.dao;

import java.util.List;

public interface PostRepository<T,U,K>{
    T getById(K k);
    List<T> getAll();
    Boolean save(U u);
    T update(U u, K k);
    Boolean delete(K k);
    List<T> userPosts(K k);

    Integer getPostlike(Integer postId);

    Integer unlike(Integer postId);
}
