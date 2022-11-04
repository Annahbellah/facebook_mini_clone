package dev.decagon.facebookcloneapp.dto;

import dev.decagon.facebookcloneapp.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewPostDTO {
    private  Integer id;
    private  Integer likes;
    private  String textBody;
    private  String userName;
    private Integer userId;
    private List<Comment> comments;
}
