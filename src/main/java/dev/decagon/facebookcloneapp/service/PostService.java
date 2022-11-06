package dev.decagon.facebookcloneapp.service;

import dev.decagon.facebookcloneapp.dto.PostDTO;
import dev.decagon.facebookcloneapp.model.Comment;
import dev.decagon.facebookcloneapp.model.Post;

import java.util.List;

public interface PostService {
    Boolean save(PostDTO post);
    List<Post>getAllPosts();

    void unlikeAPost(Integer userId,Integer postId);
    Integer like(Integer postId);

    List<Comment> getCommentsByPostById(Integer postId);

    Boolean delete(Integer postId);

    boolean edit(Integer postId,String message);

    Post get(Integer postid);
}
