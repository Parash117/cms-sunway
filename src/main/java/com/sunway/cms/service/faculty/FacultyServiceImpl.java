package com.sunway.cms.service.faculty;

import com.sunway.cms.entity.facutly.Faculty;
import com.sunway.cms.entity.subjects.Subjects;
import com.sunway.cms.repo.faculty.FacultyRepo;
import com.sunway.cms.repo.subject.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepo facultyRepo;

    private final SubjectRepo subjectRepo;

    public FacultyServiceImpl(FacultyRepo facultyRepo, SubjectRepo subjectRepo) {
        this.facultyRepo = facultyRepo;
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Faculty create(Faculty faculty) {
//        List<Subjects> subjectsList = subjectRepo.saveAll(faculty.getSubjectList());
//        faculty.setSubjectList(subjectsList);
        //sessionId ---> user Ip, user role.
        faculty = facultyRepo.save(faculty);
        return faculty;
    }

    @Override
    public Faculty update(Faculty faculty) {
        Faculty faculty1 = facultyRepo.findById(faculty.getId()).orElseThrow(()-> new RuntimeException("" +
                "not found"));

        faculty1.setName(faculty.getName());
        faculty1.setDetails(faculty.getDetails());
        faculty1 = facultyRepo.save(faculty1);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Faculty faculty1 = facultyRepo.findById(id).orElseThrow(()-> new RuntimeException("" +
                "not found"));
        facultyRepo.deleteById(id);

    }
}
