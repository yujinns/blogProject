package yujinns.blog.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Comment {


    private String id;
    private String content;

    // private String comment_like;

    // 게시물과 댓글 간의 관계 설정
    //  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    //  private List<Comment> comments = new ArrayList<>();

}
