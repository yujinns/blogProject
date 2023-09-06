package yujinns.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {

    void makeBlog(String blog_name);

    void selectGame(String game_id);

}
