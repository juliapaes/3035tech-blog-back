package com.tech.techblogback.model;

import com.tech.techblogback.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "posts")
public class Posts extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String photoLink;

    private boolean privatePost;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID_USER")
    private Users users;

}
