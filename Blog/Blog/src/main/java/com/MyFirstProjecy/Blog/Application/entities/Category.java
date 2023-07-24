package com.MyFirstProjecy.Blog.Application.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catrgoryId;

    @Column(name = "catrgoryTitle", length = 100,nullable = false)
    private String catrgoryTitle;

    private String catrgoryDescription;


}
