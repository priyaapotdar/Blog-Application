package com.MyFirstProjecy.Blog.Application.services;

import com.MyFirstProjecy.Blog.Application.payloads.CommentsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    CommentsDto createComment(CommentsDto commentsDto);

    CommentsDto updateComment(CommentsDto commentsDto);

    void deleteComment(Integer commentId);

}
