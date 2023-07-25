package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.entities.Category;
import com.MyFirstProjecy.Blog.Application.entities.Post;
import com.MyFirstProjecy.Blog.Application.entities.User;
import com.MyFirstProjecy.Blog.Application.exception.ResourceNotFoundException;
import com.MyFirstProjecy.Blog.Application.payloads.PostDto;
import com.MyFirstProjecy.Blog.Application.repositories.CategoryRepository;
import com.MyFirstProjecy.Blog.Application.repositories.PostRepository;
import com.MyFirstProjecy.Blog.Application.repositories.UserRepository;
import com.MyFirstProjecy.Blog.Application.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = new Post();
        newPost.setPostTitle(postDto.getPostTitle());
        newPost.setContent(postDto.getContent());
        newPost.setImageName("default.png");
        newPost.setDate(new Date());
        Category cat = categoryRepository.findById(postDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("user", "userId", postDto.getUserId()));
        newPost.setCategory(cat);
        User user = userRepository.findById(postDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", postDto.getCategoryId()));;
        newPost.setUser(user);
        postRepository.save(newPost);
        return modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post newPost = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("post","postId",postId));
        newPost.setPostTitle(postDto.getPostTitle());
        newPost.setContent(postDto.getContent());
        newPost.setImageName("default.png");
        postRepository.save(newPost);
        return modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->new ResourceNotFoundException("post","postId",postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
        return postRepository.findAll().stream().map(n -> modelMapper.map(n,PostDto.class)).toList();
    }

    @Override
    public PostDto getPost(Integer postId) {
        Post newPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
        return modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));;
        List<PostDto> newCatList = postRepository.findByCategory(cat).stream().map(n-> modelMapper.map(n,PostDto.class)).collect(Collectors.toList());
        return newCatList;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));;
        List<PostDto> newCatList = postRepository.findByUser(user).stream().map(n-> modelMapper.map(n,PostDto.class)).collect(Collectors.toList());
        return newCatList;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
