package com.sunway.cms.repo.subject;

import com.sunway.cms.entity.subjects.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subjects, Long> {


}
