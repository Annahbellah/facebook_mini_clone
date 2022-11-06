package dev.decagon.facebookcloneapp.controller;

import dev.decagon.facebookcloneapp.dto.CommentDTO;
import dev.decagon.facebookcloneapp.dto.ViewPostDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;
import dev.decagon.facebookcloneapp.service.CommentService;
import dev.decagon.facebookcloneapp.service.CommentServiceImpl;
import dev.decagon.facebookcloneapp.service.PostService;
import dev.decagon.facebookcloneapp.service.PostServiceImpl;
import dev.decagon.facebookcloneapp.util.CommentMapper;
import dev.decagon.facebookcloneapp.util.ConnectionInitializer;
import dev.decagon.facebookcloneapp.util.PostMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = {"/comments/","/comments/comment/"})
public class CommentController extends HttpServlet {
    private Connection connection;
    private CommentService commentService;
    private  PostService postService;

    public  void init(){
        connection= ConnectionInitializer.getConnected();
        commentService=new CommentServiceImpl(connection);
        postService=new PostServiceImpl(connection);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer postId=Integer.parseInt(request.getParameter("postid"));
        List<Comment> comments=commentService.postComments(postId);
        System.out.println(comments);
        request.getSession().setAttribute("comments", CommentMapper.commentMapping(comments));
        request.getSession().setAttribute("post", PostMapper.postToViewPost(postService.get(postId)));
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/comment.jsp"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("user");
        String comment=request.getParameter("comment");
        ViewPostDTO post=(ViewPostDTO) request.getSession().getAttribute("post");

        commentService.save(CommentDTO.builder()
                .userName(user.getName())
                .userId(user.getId())
                .textBody(comment)
                .postId(post.getId())
                .likes(0)
                .build());
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()
                + "/comments/comment/?postid="+post.getId()));
    }
    public  void destroy(){
        ConnectionInitializer.closeDBConnection(connection);
    }
}
