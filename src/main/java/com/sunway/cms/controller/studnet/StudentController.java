package com.sunway.cms.controller.studnet;

import com.sunway.cms.abstracts.BaseController;
import com.sunway.cms.dto.global.ApiResponse;
import com.sunway.cms.dto.student.StudentDTO;
import com.sunway.cms.entity.fooditems.FoodItems;
import com.sunway.cms.service.students.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO){
        studentDTO = studentService.create(studentDTO);
        return ResponseEntity.ok(new ApiResponse<>(
                messageSource.get("create", messageSource.get("student")), true, studentDTO
        ));
    }


}
