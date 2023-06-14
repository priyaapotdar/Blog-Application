package com.MyFirstProjecy.Blog.Application.repositories;

import com.MyFirstProjecy.Blog.Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
