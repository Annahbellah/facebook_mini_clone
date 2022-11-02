package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

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
