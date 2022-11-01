package com.courage.fbclone.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private  Integer id;
    private  Integer likes;
    private  String textBody;
    private Integer userId;


}
