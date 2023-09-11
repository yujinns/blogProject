package yujinns.blog.DTO;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@Getter
@Setter
public class Board {

    private int boardIdx;
    private String title;
    private String content;
    private String name;
    private Date createdtime;
    private int hitcnt;
    private Date updatedtime;

}
