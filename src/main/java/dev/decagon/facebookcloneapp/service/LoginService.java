package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.LoginDTO;
import dev.decagon.facebookcloneapp.model.User;

public interface LoginService {
    User login(String email, String password);
    Boolean save(LoginDTO login);
    Boolean editPassword(String email,String oldPassword, String newPassword);
}
