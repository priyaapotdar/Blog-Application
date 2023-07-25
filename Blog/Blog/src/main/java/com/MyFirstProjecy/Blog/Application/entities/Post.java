package com.MyFirstProjecy.Blog.Application.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", length = 100,nullable = false)
    private String postTitle;

    @Column(name = "content", length = 10000)
    private String content;

    private String imageName;

    private Date date;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "catrgoryId")
    private Category category;


}
