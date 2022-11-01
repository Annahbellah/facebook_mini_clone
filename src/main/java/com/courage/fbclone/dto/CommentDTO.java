package com.courage.fbclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private  Integer userId;
    private  Integer postId;
    private  String textBody;
    private  Integer likes;
}
