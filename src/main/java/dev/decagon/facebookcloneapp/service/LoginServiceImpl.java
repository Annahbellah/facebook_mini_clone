package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dao.LoginRepository;
import dev.decagon.facebookcloneapp.dao.LoginRepositoryImpl;
import dev.decagon.facebookcloneapp.dao.UserRepository;
import dev.decagon.facebookcloneapp.dao.UserRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.LoginDTO;
import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.exeption.LoginException;
import dev.decagon.facebookcloneapp.model.Login;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.Connection;
import java.util.Objects;

public class LoginServiceImpl implements LoginService {
    private  final Connection connection;
    private  final UserRepository userRepository;
    private  final LoginRepository loginRepository;

    public LoginServiceImpl(Connection connection) {
        this.connection = connection;
        userRepository=new UserRepositoryImpl(connection);
        loginRepository=new LoginRepositoryImpl(connection);
    }

    public User login(String email, String password){

        Login login=loginRepository.get(email);
        if(Objects.equals(login.getPassword(), password)){
            return userRepository.getById(login.getUserId());
        }
        throw new LoginException("Wrong login input");
    }

    @Override
    public Boolean save(LoginDTO login) {
        return loginRepository.save(login);
    }

    @Override
    public Boolean editPassword(String email, String oldPassword, String newPassword)throws EntityRepositoryExeption {
        Boolean result=false;

        Login login=loginRepository.get(email);
        if (login.getPassword()==oldPassword){
            result=loginRepository.editPassword(email,newPassword);
        }
        return result;
    }
    
}
