package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.payloads.CommentsDto;
import com.MyFirstProjecy.Blog.Application.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentsDto createComment(CommentsDto commentsDto) {
        return null;
    }

    @Override
    public CommentsDto updateComment(CommentsDto commentsDto) {
        return null;
    }

    @Override
    public List<CommentsDto> getAllComments(Integer postId) {
        return null;
    }

    @Override
    public CommentsDto getCommentByUserId(Integer userId) {
        return null;
    }
}
