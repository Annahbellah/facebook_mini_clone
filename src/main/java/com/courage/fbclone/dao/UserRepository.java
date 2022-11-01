package com.courage.fbclone.dao;

import dev.decagon.facebookcloneapp.enums.Gender;
import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements BaseRepository<User, Integer>{
    private  Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getById(Integer userId) {

        User user=new User();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from user where user_id=" + userId);

            if(rs.next())
            {
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setGender(Gender.valueOf(rs.getString("gender")));

            }
        }catch(SQLException e){
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> result=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from user");

            while(rs.next())
            {
                User user=new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setGender(Gender.valueOf(rs.getString("gender")));
                result.add(user);
            }
        }catch(SQLException e){
        }
        return result;
    }

    @Override
    public Boolean save(User user)  {
        String name=user.getName();
        String email=user.getEmail();
        String gender=user.getGender().name();
        int rs=0;
        Boolean result=false;
        try {
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO user(name,email,gender) VALUES ('"+name+"', '"+email+"', '"+gender+"')");
            rs = st.executeUpdate();
            result=true;
        }catch (SQLException e){

        }
        if(rs>=1) return result;
        throw new EntityRepositoryExeption("User not added");
    }
    @Override
    public User update(User user) {
        User existingUser=getById(user.getId());

//        existingUser.setGender(user.getGender());
//        existingUser.setName(user.getName());
//        existingUser.setEmail(user.getEmail());
//        String name=user.getName();
//        String email=user.getEmail();
//        String gender=user.getGender().name();

//        user_id int AUTO_INCREMENT PRIMARY KEY not null,
//                name varchar(50) NOT NULL,
//        email varchar(50) NOT NULL UNIQUE,
//                gender varchar (10) not null


        String query = ("UPDATE user SET name=?,email=?,gender=? WHERE user_id=?");
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, String.valueOf(user.getName()));
            pstmt.setString(2, String.valueOf(user.getEmail()));
            pstmt.setString(3, String.valueOf(user.getGender().name()));

            pstmt.executeUpdate();


        String sql="UPDATE user SET name='"+ name+"', mail='"+email+"', gender='"+gender+"') where user_id="+user.getId();
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,name);

            rs = st.executeUpdate();
        }catch (SQLException e){

        }
        if(rs>=1) return user;
        throw new EntityRepositoryExeption("Update error");
    }
    @Override
    public Boolean delete(User user) {
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement("delete from user where user_id=" + user.getId());
            rs = st.executeUpdate();
        }catch (SQLException e){
        }
        if(rs>=1) return true;
        throw new EntityRepositoryExeption("User with : "+user.getId()+" not found");
    }



}

