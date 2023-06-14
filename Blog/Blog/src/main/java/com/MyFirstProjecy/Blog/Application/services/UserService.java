package com.MyFirstProjecy.Blog.Application.services;

import com.MyFirstProjecy.Blog.Application.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto newUser);

    UserDto updateUser(UserDto newUser,Integer userId);

    UserDto getUser(Integer userId);

    List<UserDto> getAllUser();

    Boolean deleteUser(Integer userId);

}
