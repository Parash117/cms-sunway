package com.sunway.cms.service.students;

import com.sunway.cms.dto.student.StudentDTO;
import com.sunway.cms.entity.facutly.Faculty;
import com.sunway.cms.entity.students.Students;
import com.sunway.cms.repo.student.StudentRepo;
import com.sunway.cms.repo.subject.SubjectRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final SubjectRepo subjectRepo;
    private final StudentRepo studentRepo;

    public StudentServiceImpl(SubjectRepo subjectRepo,
                              StudentRepo studentRepo) {
        this.subjectRepo = subjectRepo;
        this.studentRepo = studentRepo;
    }


    @Override
    public StudentDTO create(StudentDTO studentDTO) {
        Students students = Students.builder()
                .rollNum(studentDTO.getRollNum())
                .batch(studentDTO.getBatch())
                .faculty(new Faculty(studentDTO.getFacultyId()))
                .name(studentDTO.getName())
                .build();
        students = studentRepo.save(students);
        studentDTO.setId(students.getId());

        return studentDTO;
    }
}
