package com.courage.fbclone.model;

import dev.decagon.facebookcloneapp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Login {
    private  final String username;
    private  final String password;
    private  final Status status;

}
