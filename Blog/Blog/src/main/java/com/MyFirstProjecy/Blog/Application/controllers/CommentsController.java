package com.MyFirstProjecy.Blog.Application.controllers;

import com.MyFirstProjecy.Blog.Application.payloads.ApiResponse;
import com.MyFirstProjecy.Blog.Application.payloads.CommentsDto;
import com.MyFirstProjecy.Blog.Application.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto commentsDto) {
        CommentsDto comm = commentService.createComment(commentsDto);
        return new ResponseEntity<CommentsDto>(comm, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CommentsDto> updateComment(@RequestBody CommentsDto commentsDto) {
        CommentsDto comm = commentService.updateComment(commentsDto);
        return new ResponseEntity<CommentsDto>(comm, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully",true),HttpStatus.OK);
    }
}
