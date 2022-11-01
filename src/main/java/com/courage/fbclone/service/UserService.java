package com.courage.fbclone.service;

import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.util.List;

public interface UserService {
    User get(Integer id);
    List<User> getAllUsers(String name);
    User update(Integer userId, UserDTO userDTO);
    User save(User user);
    Boolean delete(User user);
    List<Comment> getComments(Integer userId);
    List<Comment> getPosts(Integer userId);


}
