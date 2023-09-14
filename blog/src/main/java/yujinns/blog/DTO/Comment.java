package yujinns.blog.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Comment {


    private String id;
    private String content;

    // private String comment_like;

}