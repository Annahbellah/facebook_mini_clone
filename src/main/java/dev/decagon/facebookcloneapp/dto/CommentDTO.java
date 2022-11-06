package dev.decagon.facebookcloneapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private  Integer commentId;
    private  Integer userId;
    private String userName;
    private  Integer postId;
    private  String textBody;
    private  Integer likes;
}
