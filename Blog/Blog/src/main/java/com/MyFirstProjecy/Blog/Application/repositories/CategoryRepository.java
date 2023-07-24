package com.MyFirstProjecy.Blog.Application.repositories;

import com.MyFirstProjecy.Blog.Application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
