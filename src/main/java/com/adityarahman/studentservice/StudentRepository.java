package com.adityarahman.studentservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByName(String name);

    @Query("select avg (grade) from Student where active=true")
    Double getAverageGradeForActiveStudents();
}
