package dev.decagon.facebookcloneapp.util;

import dev.decagon.facebookcloneapp.dao.UserRepository;
import dev.decagon.facebookcloneapp.dao.UserRepositoryImpl;
import dev.decagon.facebookcloneapp.dto.CommentDTO;
import dev.decagon.facebookcloneapp.model.Comment;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {
    public  static List<CommentDTO> commentMapping(List<Comment> comments){
        Connection connection= ConnectionInitializer.getConnected();
        UserRepository userRepository=new UserRepositoryImpl(connection);

        return comments.stream()
                .map((c -> {
                    return CommentDTO.builder()
                            .userId(c.getUserId())
                            .postId(c.getPostId())
                            .textBody(c.getTextBody())
                            .likes(c.getLikes())
                            .commentId(c.getCommentId())
                            .userName(userRepository.getById(c.getUserId()).getName())
                            .build();

                }))
                .collect(Collectors.toList());
    }
}
