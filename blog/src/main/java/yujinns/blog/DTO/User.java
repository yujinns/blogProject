package yujinns.blog.DTO;

import lombok.*;

@Data
public class User {

    private String idx;
    private String id;
    private String password;
    private String nickname;
    private int pwd_q;
    private String pwd_a;
    private String email;
    private String intro;

}
