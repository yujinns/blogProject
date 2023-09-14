package yujinns.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yujinns.blog.DTO.Comment;
import yujinns.blog.service.CommentService;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
//
//    @GetMapping("/commentinsert")
//    public String commentinsert() {
//        return "/commentinsert";
//    }
//
//    @PostMapping("/commentinsert")
//    public String commentinsert(Comment comment) {
//        System.out.println(comment);
//        commentService.insertComment(comment);
//        return "/commentinsert";
//    }
//
//    @GetMapping("/commentlist")
//    public String commentList(Model model) {
//        List<Comment> comments = commentService.getAllComments();
//        System.out.println(comments);
//        model.addAttribute("comments", comments);
//        return "/commentlist";
//    }
//
//    @GetMapping("/select")
//    public String select() {
//        return "/select";
//    }
//
//    @GetMapping("/select_info")
//    public String select(String id, Model model) {
//        Comment comment = commentService.selectCommentById(id);
//        System.out.println(comment);
//        model.addAttribute("comment", comment);
//        return "/select_info";
//    }
//
//    @GetMapping("/update")
//    public String update() {
//        return "/update";
//    }
//
//    @GetMapping("/update_info")
//    public String update(String id, Model model) {
//        Comment comment = commentService.selectCommentById(id);
//        model.addAttribute("comment", comment);
//        return "/update_info";
//    }
//
//    @PostMapping("/update")
//    public String updateComment(Comment comment) {
//        commentService.updateCommentById(comment);
//        return "redirect:/commentlist";
//    }
//
//    @GetMapping("/delete")
//    public String delete() {
//        return "/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(String id) {
//        commentService.deleteCommentById(id);
//        return "redirect:/commentlist";
//    }
}