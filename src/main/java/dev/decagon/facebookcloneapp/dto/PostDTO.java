package dev.decagon.facebookcloneapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private  Integer id;
    private  Integer likes;
    private  String textBody;
    private  String userName;
    private Integer userId;

}
