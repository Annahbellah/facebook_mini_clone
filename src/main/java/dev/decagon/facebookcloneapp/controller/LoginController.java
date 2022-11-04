package dev.decagon.facebookcloneapp.controller;

import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.model.User;
import dev.decagon.facebookcloneapp.service.LoginService;
import dev.decagon.facebookcloneapp.service.LoginServiceImpl;
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
import java.util.List;

@WebServlet(urlPatterns = {"/login","/in"})
public class LoginController extends HttpServlet {
    private  Connection connection;
    private LoginService loginService;
    private PostService postService;

    public  void init(){
        connection= ConnectionInitializer.getConnected();
        loginService=new LoginServiceImpl(connection);
        postService=new PostServiceImpl(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=(String)request.getParameter("email");
        String password=(String)request.getParameter("password");
        User user=null;

        try {
            user=loginService.login(email,password);

            List<Post> posts=postService.getAllPosts();
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("posts",posts);
            request.getSession().setAttribute("username",user.getName());
            response.sendRedirect("home");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void destroy(){
        ConnectionInitializer.closeDBConnection(connection);
    }
}
