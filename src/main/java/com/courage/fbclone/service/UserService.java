package com.courage.fbclone.service;


import com.courage.fbclone.dto.UserDTO;
import com.courage.fbclone.model.Comment;
import com.courage.fbclone.model.User;

import java.util.List;

public interface UserService {
    User get(Integer id);
    List<User> getAllUsers(String name);
    User update(Integer userId, UserDTO userDTO);

    User save(UserDTO user);

    Boolean delete(Integer userid);
    List<Comment> getComments(Integer userId);
    List<Comment> getPosts(Integer userId);


}
