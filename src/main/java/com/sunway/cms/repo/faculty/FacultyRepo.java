package com.sunway.cms.repo.faculty;

import com.sunway.cms.entity.facutly.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {

}
