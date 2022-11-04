package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository<Post, PostDTO,Integer>{


    Connection connection;

    public PostRepositoryImpl(Connection connection) {
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
            while(rs.next())
            {
                Post post=new Post();
                post.setUserId(rs.getInt("user_id"));
                post.setId(rs.getInt("post_id"));
                post.setTextBody(rs.getString("text_body"));
                post.setUserName(rs.getString("username"));
                post.setLikes(rs.getInt("likes"));
                posts.add(post);

            }
        }catch(SQLException e){
        }

        return posts;
    }

    @Override
    public Boolean save(PostDTO post) {
        String textbody= post.getTextBody();
        String username=post.getUserName();
        Integer user_id= post.getUserId();
        Integer likes= post.getLikes();
        String INSERT_USERS_SQL = "INSERT INTO post (text_body,user_id,username,likes) VALUES " + " (?, ?,?, ?);";
        Boolean result=false;
        try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

                preparedStatement.setString(1, textbody);
                preparedStatement.setInt(2, user_id);
                preparedStatement.setString(3, username);
                preparedStatement.setInt(4, likes);

                preparedStatement.executeUpdate();
                result=true;
        }catch (SQLException e){

        }
        return result;
    }

        @Override
    public Post update(PostDTO post, Integer postId) {

            String query = ("UPDATE post SET text_body=? WHERE postId="+postId);
            try {
                PreparedStatement stmt = connection.prepareStatement(query);

                stmt.setString(1, String.valueOf(post.getTextBody()));

                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new EntityRepositoryExeption("Update not successful");
            }
            return getById(postId);
    }

    @Override
    public Boolean delete(Integer postId) {
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement("delete from post where id=" + postId);
            rs = st.executeUpdate();
        }catch (SQLException e){}
        if(rs>=1) return true;
        throw new EntityRepositoryExeption("Post with : "+postId+" not found");

    }

    @Override
    public List<Post> userPosts(Integer userId) {
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
                post.setUserName(rs.getString("username"));
                post.setLikes(rs.getInt("likes"));
                posts.add(post);

            }
        }catch(SQLException e){
        }

        return posts;
    }

    @Override
    public Integer getPostlike(Integer postId) {
        Integer likes=0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select likes from post where user_id="+postId);
            if(rs.next())
            {
                likes=rs.getInt("likes");
            }
        }catch(SQLException e){
        }
        return likes;
    }

    @Override
    public Integer unlike(Integer postId) {
        return 0;
    }
}
