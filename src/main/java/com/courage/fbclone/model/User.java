package com.courage.fbclone.model;

import com.courage.fbclone.enums.Gender;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String email;
    private Gender gender;
}


