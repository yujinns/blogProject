package yujinns.blog.DTO;

import lombok.*;

import java.sql.Timestamp;


@Data
@Getter
@Setter
public class Board {

    private int boardIdx;
    private String title;
    private String content;
    private String name;
    private String pwd;
    private Timestamp createdtime;
    private int hitcnt;
    private Timestamp updatedtime;

}
