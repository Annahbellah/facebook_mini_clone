package dev.decagon.facebookcloneapp.controller;

import dev.decagon.facebookcloneapp.dto.ViewPostDTO;
import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.model.User;
import dev.decagon.facebookcloneapp.service.PostService;
import dev.decagon.facebookcloneapp.service.PostServiceImpl;
import dev.decagon.facebookcloneapp.util.ConnectionInitializer;
import dev.decagon.facebookcloneapp.util.PostMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/edit/" ,"/edit"})
public class EditPostController extends HttpServlet {
    private Connection connection;
    private PostService postService;

    public  void init(){
        connection= ConnectionInitializer.getConnected();
        postService=new PostServiceImpl(connection);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post=postService.get(Integer.parseInt( request.getParameter("postid")));
        ViewPostDTO postDTO= PostMapper.postToViewPost(post);

        User user=(User)request.getSession().getAttribute("user");
        request.getSession().setAttribute("post",postDTO);
        if (user.getId()==postDTO.getUserId()){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/edit.jsp"));
        }else {
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message=(String) request.getParameter("textbody");
        User user=(User)request.getSession().getAttribute("user");
        ViewPostDTO postDTO=(ViewPostDTO)request.getSession().getAttribute("post");
        if(user.getId()==postDTO.getUserId()){
            postService.edit(postDTO.getId(),message);
            response.sendRedirect("home");

        }else  response.sendRedirect("home");

    }
    public void destroy(){
        ConnectionInitializer.closeDBConnection(connection);
    }
}
