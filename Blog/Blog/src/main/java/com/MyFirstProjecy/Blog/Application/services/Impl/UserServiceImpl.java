package com.MyFirstProjecy.Blog.Application.services.Impl;

import com.MyFirstProjecy.Blog.Application.entities.User;
import com.MyFirstProjecy.Blog.Application.exception.ResourceNotFoundException;
import com.MyFirstProjecy.Blog.Application.payloads.UserDto;
import com.MyFirstProjecy.Blog.Application.repositories.UserRepository;
import com.MyFirstProjecy.Blog.Application.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto newUser) {
        User user = this.dtoToUser(newUser);
        this.userRepository.save(user);
        return this.userToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto newUser, Integer userId) {
        Optional<User> user = Optional.ofNullable(this.userRepository.
                findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));

        User updatedUser = User.builder().id(newUser.getId()).about(newUser.getAbout())
                .email(newUser.getEmail()).name(newUser.getName()).password(newUser.getPassword()).build();

        this.userRepository.save(updatedUser);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUser(Integer userId) {
        Optional<User> user = Optional.ofNullable(this.userRepository.
                findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));
        return this.userToDto(user.get());
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = this.userRepository.findAll();

        return userList.stream().map(n -> userToDto(n)).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        boolean isDeleted = false;
        Optional<User> user = Optional.ofNullable(this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));
        this.userRepository.delete(user.get());
        isDeleted = true;
        return isDeleted;
    }

    private User dtoToUser(UserDto dto){
       return this.modelMapper.map(dto,User.class);
    }

    private UserDto userToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }

}
