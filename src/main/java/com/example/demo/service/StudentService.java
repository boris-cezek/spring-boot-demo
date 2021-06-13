package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mockDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student) {
        checkAgeGroup(student);
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }

    public int deleteStudent(UUID id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(UUID id, Student newStudent) {
        checkAgeGroup(newStudent);
        return studentDao.updateStudentById(id, newStudent);
    }

    private void checkAgeGroup(Student student){
        int age = student.getAge().intValue();

        if (Objects.isNull(student.getAge()) || age == 0 ){
            student.putAgeGroup("Undefined");
        } else {

            switch ((1 <= age && age < 20 ) ? 0 :
                    (20 <= age && age < 50) ? 1 :
                            (50 <= age && age < 70) ? 2 :
                                    (age >= 70) ? 3 :4) {

                case 0:
                    student.putAgeGroup("Under 20");
                    break;
                case 1:
                    student.putAgeGroup("20 - 50");
                    break;
                case 2:
                    student.putAgeGroup("50 - 70");
                    break;
                case 3:
                    student.putAgeGroup("Over 70");
                    break;
                case 4:
                    student.putAgeGroup("Undefined");
                    break;
            }
        }
    }
}
