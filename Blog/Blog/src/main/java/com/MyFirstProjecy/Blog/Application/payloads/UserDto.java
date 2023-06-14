package com.MyFirstProjecy.Blog.Application.payloads;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;


    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String about;

}


