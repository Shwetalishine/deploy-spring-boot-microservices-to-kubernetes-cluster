package com.app.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentId;
}
