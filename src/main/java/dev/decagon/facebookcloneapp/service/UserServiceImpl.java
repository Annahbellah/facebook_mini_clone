package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dao.UserRepository;
import dev.decagon.facebookcloneapp.dao.UserRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.UserDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.User;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final Connection connection;
    private  final UserRepository userRepository;

    public UserServiceImpl(Connection connection) {
        this.connection = connection;
        this.userRepository = new UserRepositoryImpl(connection);
    }

    @Override
    public User get(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers(String name) {
        return userRepository.getAll();
    }

    @Override
    public User update(Integer userId, UserDTO userDTO){
        return  userRepository.update(userId,userDTO);
    }
    @Override
    public User save(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Integer userId) {
        return userRepository.delete(userId);
    }

    @Override
    public List<Comment> getComments(Integer userId) {
       return userRepository.getUserComments(userId);
    }

    @Override
    public List<Comment> getPosts(Integer userId) {
        return userRepository.getUserPosts(userId);
    }


//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        UserServiceImpl service=new UserServiceImpl();
//
//
//        UserRepositoryImpl userRepository=new UserRepositoryImpl(connection);
//        User user=userRepository.getById(4);
//        System.out.println(user);
//
//        UserDTO userDTO=UserDTO.builder()
//                .gender(Gender.MALE)
//                .email("no@sm.com")
//                .name("Mike")
//                .build();
//
//    }


}
