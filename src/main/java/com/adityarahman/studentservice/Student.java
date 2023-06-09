package com.adityarahman.studentservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private int grade;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
