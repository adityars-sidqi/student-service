package com.adityarahman.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class StudentCacheTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;


    @Test
    void getStudentById_forMultipleRequest_isRetrievedFromCache()
    {
        //given
        Long id = 123L;
        given(studentRepository.findById(id)).willReturn(Optional.of(new Student(null, "Mark")));

        //when
        studentService.getStudentById(id);
        studentService.getStudentById(id);
        studentService.getStudentById(id);

        //then
        then(studentRepository).should(times(1)).findById(id);
    }
}
