package com.sunway.cms.repo.student;

import com.sunway.cms.entity.students.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long> {


}
