package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.entities.Comments;
import com.MyFirstProjecy.Blog.Application.entities.Post;
import com.MyFirstProjecy.Blog.Application.exception.ResourceNotFoundException;
import com.MyFirstProjecy.Blog.Application.payloads.CommentsDto;
import com.MyFirstProjecy.Blog.Application.repositories.CommentsRepository;
import com.MyFirstProjecy.Blog.Application.repositories.PostRepository;
import com.MyFirstProjecy.Blog.Application.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentsDto createComment(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("post", "postId", commentsDto.getPostId()));
        Comments newComment = modelMapper.map(commentsDto, Comments.class);
        newComment.setPost(post);
        Comments savedComments = commentsRepository.save(newComment);
        return modelMapper.map(savedComments,CommentsDto.class);
    }
    @Override
    public CommentsDto updateComment(CommentsDto commentsDto) {
        Comments newComment = commentsRepository.findById(commentsDto.getId()).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentsDto.getId()));
        newComment.setComment(commentsDto.getComment());
        commentsRepository.save(newComment);
        return  modelMapper.map(newComment,CommentsDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comments comment = commentsRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId",commentId));
        commentsRepository.delete(comment);
    }

}
