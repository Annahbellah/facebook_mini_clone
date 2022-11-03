package dev.decagon.facebookcloneapp.controller;

import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.model.User;
import dev.decagon.facebookcloneapp.service.PostService;
import dev.decagon.facebookcloneapp.service.PostServiceImpl;
import dev.decagon.facebookcloneapp.util.ConnectionInitializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/post"})
public class PostController extends HttpServlet {

    private Connection connection;
    private PostService postService;

    public  void init(){
        connection= ConnectionInitializer.getConnected();
        postService=new PostServiceImpl(connection);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user= (User)request.getSession().getAttribute("user");
        String textBody=(String)request.getParameter("textbody");

        PostDTO post=PostDTO.builder().userId(user.getId()).textBody(textBody).likes(0).build();
        Post postEntity=postService.save(post);

    }
}
