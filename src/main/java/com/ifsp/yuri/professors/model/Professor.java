package com.ifsp.yuri.professors.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "professors")
@Getter @Setter
public class Professor {

    @Id
    private String id;
    private String name;
    private String email;

    public Professor(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
}
