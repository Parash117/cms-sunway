package com.sunway.cms.controller.faculty;

import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.entity.facutly.Faculty;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.service.faculty.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController extends BaseController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/session-id/{sessionId}")
    public ResponseEntity<?> create(@RequestBody Faculty faculty){
        faculty = facultyService.create(faculty);
        return ResponseEntity.ok(new ApiResponse<>(
                messageSource.get("get.all", messageSource.get("categories")), true, faculty
        ));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> create(@PathVariable("id") Long id){
        facultyService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(
                messageSource.get("get.all", messageSource.get("categories")), true, null
        ));
    }

}
