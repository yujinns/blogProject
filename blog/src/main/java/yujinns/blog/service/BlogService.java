package yujinns.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yujinns.blog.DTO.Blog;
import yujinns.blog.mapper.BlogMapper;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;


    public void makeBlog(String blog_name) {
        blogMapper.makeBlog(blog_name);
    }

    public Blog selectGame(String game_id ) { return blogMapper.selectGame(game_id);}

}