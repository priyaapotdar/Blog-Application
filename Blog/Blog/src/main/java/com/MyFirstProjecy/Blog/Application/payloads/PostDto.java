package com.MyFirstProjecy.Blog.Application.payloads;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Validated
public class PostDto {

    private Integer postId;

    private String postTitle;

    private String content;

    private Date date;

    private String imageName;

    private Integer userId;

    private Integer categoryId;

}
