package dev.decagon.facebookcloneapp.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String email;
    private  String password;
    private Integer userId;
}



