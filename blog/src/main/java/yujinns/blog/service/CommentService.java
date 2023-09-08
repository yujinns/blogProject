package yujinns.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yujinns.blog.DTO.Comment;
import yujinns.blog.mapper.CommentMapper;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

//    public void insertComment(Comment comment) {
//        commentMapper.insertComment(comment);
//    }
//
//    public List<Comment> getAllComments() {
//        return commentMapper.getAllComments();
//    }
//
//    public Comment selectCommentById(String id) { return commentMapper.selectCommentById(id);}
//
//    public void deleteCommentById(String id) {commentMapper.deleteCommentById(id);}
//
//    public void updateCommentById(Comment comment) { commentMapper.updateCommentById(comment);}
}


