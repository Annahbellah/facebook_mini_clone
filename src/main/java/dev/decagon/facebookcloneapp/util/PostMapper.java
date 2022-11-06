package dev.decagon.facebookcloneapp.util;

import dev.decagon.facebookcloneapp.dto.ViewPostDTO;
import dev.decagon.facebookcloneapp.model.Post;
import dev.decagon.facebookcloneapp.service.PostService;
import dev.decagon.facebookcloneapp.service.PostServiceImpl;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {


    public static List<ViewPostDTO> postToViewPost(List<Post> posts){
        Connection connection=ConnectionInitializer.getConnected();
        PostService postService=new PostServiceImpl(connection);

        return posts.stream()
                .map((post -> {
                            return ViewPostDTO.builder()
                            .id(post.getId())
                            .userId(post.getUserId())
                            .userName(post.getUserName())
                            .textBody(post.getTextBody())
                            .likes(post.getLikes())
                            .comments(postService.getCommentsByPostById(post.getId()))
                            .build();
                }))
                .collect(Collectors.toList());


    }
    public  static ViewPostDTO postToViewPost(Post post){
        Connection connection=ConnectionInitializer.getConnected();
        PostService postService=new PostServiceImpl(connection);

        return ViewPostDTO.builder()
                    .id(post.getId())
                    .userId(post.getUserId())
                    .userName(post.getUserName())
                    .textBody(post.getTextBody())
                    .likes(post.getLikes())
                    .comments(postService.getCommentsByPostById(post.getId()))
                    .build();
    }
}
