package com.example.library_test.dao.entity;

//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "authors", schema = "library", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id", name = "authorIdConstraint"),
        @UniqueConstraint(columnNames = "name", name = "authorNameConstraint")
})
public class Author extends BaseEntity{
    private String name;
    private String lastname;
    private Integer birthYear;

    public Author(String name, String lastname,
                  Integer birthYear) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.birthYear = birthYear;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
}
