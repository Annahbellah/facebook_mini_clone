package com.courage.fbclone.controller;

import com.courage.fbclone.dao.ConnectionInitializer;
import com.courage.fbclone.dto.UserDTO;
import com.courage.fbclone.enums.Gender;
import com.courage.fbclone.exeption.BadAttributesException;
import com.courage.fbclone.service.UserService;

import com.courage.fbclone.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private Connection connection;
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        connection= ConnectionInitializer.getConnected();
        userService=new UserServiceImpl(connection);

        String name=(String)request.getAttribute("name");
        String email=(String)request.getAttribute("email");
        String genderStr=(String)request.getAttribute("gender");
        String password=(String)request.getAttribute("password");



        if(name==null|| email==null||genderStr==null||password==null|| password.length()<8)
            throw new BadAttributesException("Validation failed");
        Gender gender;
        if(genderStr=="MALE"){ gender=Gender.MALE;}
        else  gender=Gender.FEMALE;

        UserDTO userDTO=UserDTO.builder()
                .gender(gender)
                .email(email)
                .name(name)
                .build();
        userService.save(userDTO);
        ConnectionInitializer.closeDBConnection(connection);


    }
}
