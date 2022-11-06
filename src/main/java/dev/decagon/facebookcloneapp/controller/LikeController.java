package dev.decagon.facebookcloneapp.controller;

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

@WebServlet(urlPatterns = {"/likes/"})
public class LikeController extends HttpServlet {
    private Connection connection;
    private PostService postService;

    public  void init(){
        connection= ConnectionInitializer.getConnected();
        postService=new PostServiceImpl(connection);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer postId=Integer.parseInt( request.getParameter("postid"));
        postService.like(postId);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/home"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy(){
        ConnectionInitializer.closeDBConnection(connection);
    }
}
