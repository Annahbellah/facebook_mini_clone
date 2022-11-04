package dev.decagon.facebookcloneapp.controller;

import dev.decagon.facebookcloneapp.dto.LoginDTO;
import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.enums.Gender;
import dev.decagon.facebookcloneapp.exeption.BadAttributesException;
import dev.decagon.facebookcloneapp.model.User;
import dev.decagon.facebookcloneapp.service.LoginService;
import dev.decagon.facebookcloneapp.service.LoginServiceImpl;
import dev.decagon.facebookcloneapp.service.UserService;
import dev.decagon.facebookcloneapp.service.UserServiceImpl;
import dev.decagon.facebookcloneapp.util.ConnectionInitializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns={"/register","/signup"}  )
public class RegisterController extends HttpServlet {
    private Connection connection;
    private UserService userService;
    private LoginService loginService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        connection=ConnectionInitializer.getConnected();
        userService=new UserServiceImpl(connection);
        loginService=new LoginServiceImpl(connection);

        String name=(String)request.getParameter("name");
        String email=(String)request.getParameter("email");
        String genderStr=(String)request.getParameter("gender");
        String password=(String)request.getParameter("password");



        if(name==null|| email==null||genderStr==null||password==null|| password.length()<8)
            throw new BadAttributesException("Validation failed");
        Gender gender;
        if(genderStr.equals("MALE")){ gender=Gender.MALE;}
        else  gender=Gender.FEMALE;


        UserDTO userDTO=UserDTO.builder()
                .gender(gender)
                .email(email)
                .name(name)
                .build();
        User user=userService.save(userDTO);
        LoginDTO login=new LoginDTO(email,password, user.getId());
        loginService.save(login);
        response.sendRedirect("login.jsp");


        ConnectionInitializer.closeDBConnection(connection);


    }
}
