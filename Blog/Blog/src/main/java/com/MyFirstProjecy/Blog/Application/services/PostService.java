package com.MyFirstProjecy.Blog.Application.services;

import com.MyFirstProjecy.Blog.Application.entities.Post;
import com.MyFirstProjecy.Blog.Application.payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto updatePost(PostDto postDto,Integer postId);

    void deletePost(Integer postId);

    List<PostDto> getAllPost();

    PostDto getPost(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPost(String keyword);

}
