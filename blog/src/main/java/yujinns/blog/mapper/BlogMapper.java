package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import yujinns.blog.DTO.Blog;

@Mapper
public interface BlogMapper {

    void makeBlog(String blog_name);

    Blog selectGame(String game_id);

}