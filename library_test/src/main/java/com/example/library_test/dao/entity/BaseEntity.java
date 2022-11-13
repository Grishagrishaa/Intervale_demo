package com.example.library_test.dao.entity;

//import org.springframework.data.annotation.CreatedDate;
////import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    private UUID id = UUID.randomUUID();
//    @NotNull(message = "Internal Error | createdDate was not initialized")
    @CreatedDate
    private LocalDateTime createDate;
    @Version
    private Integer version;

    public BaseEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
