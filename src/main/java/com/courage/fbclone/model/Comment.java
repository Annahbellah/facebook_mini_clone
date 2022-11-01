package com.courage.fbclone.model;

import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    private  Integer commentId;
    private  Integer userId;
    private  Integer postId;
    private  String textBody;
    private  Integer likes;




}
