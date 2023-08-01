package com.MyFirstProjecy.Blog.Application.controllers;

import com.MyFirstProjecy.Blog.Application.payloads.ApiResponse;
import com.MyFirstProjecy.Blog.Application.payloads.PostDto;
import com.MyFirstProjecy.Blog.Application.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto createdPost = postService.createPost(postDto);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer categoryId){
        PostDto updatedPost = postService.updatePost(postDto,categoryId);
        return new ResponseEntity<PostDto>(updatedPost, HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> listOfPost = postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(listOfPost, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> listOfPost = postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(listOfPost, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> getAllPosts(Pageable page){
        List<PostDto> listOfPost = postService.getAllPost(page);
        return new ResponseEntity<List<PostDto>>(listOfPost, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPosts(@PathVariable Integer postId){
        PostDto post = postService.getPost(postId);
        return new ResponseEntity<PostDto>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ApiResponse("post is successfully deleted !!", true);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<PostDto>> getAllPostsWithKeyword(@PathVariable String keyword){
        List<PostDto> listOfPost = postService.searchPost(keyword);
        return new ResponseEntity<List<PostDto>>(listOfPost, HttpStatus.OK);
    }


}
