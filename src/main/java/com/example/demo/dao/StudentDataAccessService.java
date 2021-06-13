package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MSSQL")
public class StudentDataAccessService implements StudentDao{
    @Override
    public int insertStudent(UUID id, Student student) {
        return 0;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> tempStudent = new ArrayList<Student>();
        tempStudent.add(new Student(UUID.randomUUID(), "Testing", "Injection", 0, ""));
        return tempStudent;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteStudentById(UUID id) {
        return 0;
    }

    @Override
    public int updateStudentById(UUID id, Student student) {
        return 0;
    }
}
