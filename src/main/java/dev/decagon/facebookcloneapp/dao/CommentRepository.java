package dev.decagon.facebookcloneapp.dao;

import java.util.List;

public interface CommentRepository <T,U,K>{
    T getById(K k);
    List<T> getAll();
    Boolean save(U u);
    T update(U u, K k);
    Boolean delete(K k);
}
