package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.dto.LoginDTO;
import dev.decagon.facebookcloneapp.model.Login;

public interface LoginRepository {
    Login get(String email);
    Boolean save(LoginDTO login);
    Boolean editPassword(String email, String newPassword);

}
