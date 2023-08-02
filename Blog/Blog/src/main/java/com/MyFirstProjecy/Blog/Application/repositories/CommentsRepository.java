package com.MyFirstProjecy.Blog.Application.repositories;


import com.MyFirstProjecy.Blog.Application.entities.Comments;
import com.MyFirstProjecy.Blog.Application.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {


}
