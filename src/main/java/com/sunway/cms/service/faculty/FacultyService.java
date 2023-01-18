package com.sunway.cms.service.faculty;

import com.sunway.cms.entity.facutly.Faculty;

public interface FacultyService {

    Faculty create(Faculty faculty);
    Faculty update(Faculty faculty);

    void deleteById(Long id);
}
