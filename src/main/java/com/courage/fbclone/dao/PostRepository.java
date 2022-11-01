package com.courage.fbclone.dao;

import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository implements BaseRepository<Post,Integer>{


    Connection connection;

    public PostRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Post getById(Integer post_id) {

        Post post=new Post();


        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from post where post_id=" + post_id);

            if(rs.next())
            {
                post.setUserId(rs.getInt("user_id"));
                post.setId(rs.getInt("post_id"));
                post.setTextBody(rs.getString("text_body"));
                post.setLikes(rs.getInt("likes"));

            }
        }catch(SQLException e){
        }

        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from post");
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

    @Override
    public Boolean save(Post post) {
        String textbody= post.getTextBody();
        Integer user_id= post.getUserId();
        Integer likes= post.getLikes();
        String INSERT_USERS_SQL = "INSERT INTO post (text_body,user_id,likes) VALUES " + " (?, ?, ?);";
        Boolean result=false;
        try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                preparedStatement.setString(1, textbody);
                preparedStatement.setInt(2, user_id);
                preparedStatement.setInt(3, user_id);

                preparedStatement.executeUpdate();
                result=true;
        }catch (SQLException e){

        }
        return result;
    }

        @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Boolean delete(Post post) {
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement("delete from post where id=" + post.getId());
            rs = st.executeUpdate();
        }catch (SQLException e){}
        if(rs>=1) return true;
        throw new EntityRepositoryExeption("Post with : "+post.getId()+" not found");

    }
}
