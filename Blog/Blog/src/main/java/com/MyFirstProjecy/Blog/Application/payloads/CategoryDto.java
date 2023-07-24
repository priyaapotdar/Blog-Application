package com.MyFirstProjecy.Blog.Application.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer catrgoryId;

    @NotBlank
    @Size(min = 4)
    private String catrgoryTitle;

    @NotBlank
    @Size(max = 100)
    private String catrgoryDescription;
}
