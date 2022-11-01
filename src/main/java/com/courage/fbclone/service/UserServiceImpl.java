package com.courage.fbclone.service;

import dev.decagon.facebookcloneapp.dao.BaseRepository;
import dev.decagon.facebookcloneapp.dao.UserRepository;
import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.enums.Gender;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static Connection connection;

    

    UserRepository userRepository=new UserRepository(connection);
    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public List<User> getAllUsers(String name) {
        return null;
    }

    @Override
    public User update(Integer userId, UserDTO userDTO){
        return  null;
    }
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public List<Comment> getComments(Integer userId) {
        return null;
    }

    @Override
    public List<Comment> getPosts(Integer userId) {
        return null;
    }










    public static Connection init(){
        String driver="com.mysql.cj.jdbc.Driver";
        String connectionString="jdbc:mysql://localhost:3306/facebook_clone_app";
        String username="root";
        String password="OC@log4.2";

        Connection connection1=null;
        try {
            System.out.println("trying to connect inside init");
            connection1 = BaseRepository.connectToDB(driver, connectionString, username, password);
            System.out.println("connected inside init");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("couldn't connect");
        }
        return  connection1;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserServiceImpl service=new UserServiceImpl();
        connection= init();
        UserRepository userRepository=new UserRepository(connection);
        User user=userRepository.getById(4);
        System.out.println(user);

        UserDTO userDTO=UserDTO.builder()
                .gender(Gender.MALE)
                .email("no@sm.com")
                .name("Mike")
                .build();

    }


}
