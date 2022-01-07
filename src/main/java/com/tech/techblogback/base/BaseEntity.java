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
    @Column(name = "DELETED")
    protected boolean deleted;

    @NotNull
    @Column(name = "DATE_REG")
    protected LocalDateTime createdAt;

    @Column(name = "UPDATE_DATE")
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




