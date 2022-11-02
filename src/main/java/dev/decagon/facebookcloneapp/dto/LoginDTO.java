package dev.decagon.facebookcloneapp.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private  String password;
    private Integer userId;
}