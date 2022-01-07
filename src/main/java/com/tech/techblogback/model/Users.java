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
@Builder
@Data
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        private String name;

        private String phone;

        @NotNull
        private String email;

        @NotNull
        private String password;

        private String profileLink;



}
