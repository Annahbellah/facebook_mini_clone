package com.courage.fbclone.dao;

import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.enums.Gender;
import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository<User,UserDTO,Integer>{
    private final  Connection connection;

    public UserRepositoryImpl(Connection connection) {
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


    public  User getByEmail(String email){
        User user=new User();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from user where email=" + email);

            if(rs.next())
            {
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setGender(Gender.valueOf(rs.getString("gender")));

            }
        }catch(SQLException e){
        }

        if(user.getId()>=1) return user;
        throw new EntityRepositoryExeption("User with "+email+" not found");
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
    public User save(UserDTO user)  {
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
        return getByEmail(user.getEmail());
    }

    @Override
    public User update(UserDTO user, Integer userId) {

        String query = ("UPDATE user SET name=?,email=?,gender=? WHERE user_id=?");
        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, String.valueOf(user.getName()));
            stmt.setString(2, String.valueOf(user.getEmail()));
            stmt.setString(3, String.valueOf(user.getGender().name()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new EntityRepositoryExeption("Update not successful");
        }
        return getById(userId);
    }


    @Override
    public Boolean delete(Integer userId) {
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement("delete from user where user_id=" + userId);
            rs = st.executeUpdate();
        }catch (SQLException e){
        }
        if(rs>=1) return true;
        throw new EntityRepositoryExeption("User with : "+userId+" not found");
    }

    public List<Comment> getUserComments(Integer userId) {
        Comment comment;
        List<Comment> comments=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from comment where user_id="+userId);
            rs.next();
            while(rs.next()){
                {
                    comment=new Comment();
                    comment.setCommentId(rs.getInt("comment_id"));
                    comment.setPostId(rs.getInt("post_id"));
                    comment.setTextBody(rs.getString("text_body"));
                    comment.setUserId(rs.getInt("user_id"));
                    comment.setLikes(rs.getInt("likes"));

                    comments.add(comment);
                }
            }
        }catch(SQLException e){
        }
        return comments;
    }


    public List<Post> getUserPosts(Integer userId) {
        List<Post> posts=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from post where user_id="+userId);
            if(rs.next())
            {
                Post post=new Post();
                post.setId(rs.getInt("user_id"));
                post.setId(rs.getInt("post_id"));
                post.setTextBody(rs.getString("text_body"));
                post.setLikes(rs.getInt("likes"));
                posts.add(post);

            }
        }catch(SQLException e){
        }

        return posts;

    }

}

