package dev.decagon.facebookcloneapp.dao;

import dev.decagon.facebookcloneapp.dto.LoginDTO;
import dev.decagon.facebookcloneapp.exeption.EntityRepositoryExeption;
import dev.decagon.facebookcloneapp.model.Login;

import java.sql.*;

public class LoginRepositoryImpl implements LoginRepository {
    Connection connection;

    public LoginRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Login get(String email) {
        Login login=new Login();
        try {

            CallableStatement callableStatement= connection.prepareCall("{call getLoginByEmail(?)}");

            callableStatement.setString(1, email);
            ResultSet rs=callableStatement.executeQuery();
            if(rs.next())
            {

                login.setUserId(rs.getInt("user_id"));
                login.setEmail(rs.getString("email"));
                login.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
        }
        return login;
    }

    public Boolean save(LoginDTO login){
        String email=login.getEmail();
        String password=login.getPassword();
        Integer userId= login.getUserId();
        int rs=0;
        Boolean result=false;
        try {
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO login(email,password,user_id) VALUES ('"+email+"', '"+password+"', '"+userId+"')");
            rs = st.executeUpdate();
            result=true;
        }catch (SQLException e){

        }
        return  result;
    }

    @Override
    public Boolean editPassword(String email, String newPassword)throws EntityRepositoryExeption {

        String query = ("UPDATE login SET password=? WHERE email="+email);
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(newPassword));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new EntityRepositoryExeption("Update not successful");
        }
        return true;
    }


}
