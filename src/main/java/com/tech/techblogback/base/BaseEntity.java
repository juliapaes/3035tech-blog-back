package com.tech.techblogback.base;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @NotNull
    protected boolean deleted;

    @NotNull
    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    @PrePersist
    private void beforeInsert() {
        this.deleted = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}




