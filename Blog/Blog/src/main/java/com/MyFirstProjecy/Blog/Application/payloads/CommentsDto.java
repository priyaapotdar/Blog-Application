package com.MyFirstProjecy.Blog.Application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentsDto {

    private Integer id;

    private Integer postId;

    private String comment;

}
