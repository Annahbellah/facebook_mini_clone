package com.courage.fbclone.dao;

import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CommentRepository implements BaseRepository<Comment,Integer>{
  Connection connection;
   public CommentRepository(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Comment getById(Integer commentId) {
        Comment comment=new Comment();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from post where post_id=" + commentId);
            if(rs.next())
            {
                comment.setCommentId(rs.getInt("comment_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setTextBody(rs.getString("text_body"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setLikes(rs.getInt("likes"));
            }
        }catch(SQLException e){
        }
        return comment;
    }
    @Override
    public List<Comment> getAll() {
        Comment comment;
        List<Comment> comments=new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from post");
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
    @Override
    public Boolean save(Comment comment) {

        String textbody= comment.getTextBody();
        Integer user_id= comment.getUserId();
        Integer post_id= comment.getPostId();
        Integer likes= comment.getLikes();
        String INSERT_USERS_SQL = "INSERT INTO post (text_body,post_id,user_id,likes) VALUES " + " (?, ?, ?, ?);";
        Boolean result=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setString(1, textbody);
            preparedStatement.setInt(2, post_id);
            preparedStatement.setInt(3, user_id);
            preparedStatement.setInt(4, likes);

            preparedStatement.executeUpdate();
            result=true;
        }catch (SQLException e){

        }
        return result;
    }
    @Override
    public Comment update(Comment comment) {
        return null;
    }
    @Override
    public Boolean delete(Comment comment) {
        int rs=0;
        try {
            PreparedStatement st = connection.prepareStatement("delete from post where id=" + comment.getCommentId());
            rs = st.executeUpdate();
        }catch (SQLException e){}
        if(rs>=1) return true;
        throw new EntityRepositoryExeption("Comment with : "+comment.getCommentId()+" not found");
    }
}
