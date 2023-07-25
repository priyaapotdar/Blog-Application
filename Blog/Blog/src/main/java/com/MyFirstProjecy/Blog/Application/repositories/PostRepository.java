package com.MyFirstProjecy.Blog.Application.repositories;

import com.MyFirstProjecy.Blog.Application.entities.Category;
import com.MyFirstProjecy.Blog.Application.entities.Post;
import com.MyFirstProjecy.Blog.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
