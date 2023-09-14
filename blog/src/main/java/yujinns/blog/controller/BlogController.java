package yujinns.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import yujinns.blog.DTO.Blog;
import yujinns.blog.service.BlogService;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;


     public BlogController(BlogService blogService){
        this.blogService = blogService;
    }


    @GetMapping("/game_select")
    public String selectGame() {
        return "game_select";
    }

    @PostMapping("/game_select")
    public String selectGame(String game_id,Model model) {
        model.addAttribute("gameId", game_id);
        return "makeblog/{game_id}";
    }


    @GetMapping("/makeblog/{game_id}")
    public String makeblog(@PathVariable String game_id, Model model) {
         Blog blog = blogService.selectGame(game_id);
         String path = blog.getPath();
         model.addAttribute("path",path);
         return "makeblog";
    }

    @PostMapping("/makeblog")
    public String makeBlog(String blog_name) {
        blogService.makeBlog(blog_name);
        return "redirect:/"; // blog_main
    }





}
