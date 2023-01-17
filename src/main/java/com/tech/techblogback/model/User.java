package com.tech.techblogback.model;

import com.sun.istack.NotNull;
import com.tech.techblogback.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        private String name;

        @NotNull
        private String email;

        private String phone;

        private String profileLink;

        @OneToMany()
        @JoinColumn(name = "post_id", referencedColumnName = "id")
        private List<Post> posts;

}
