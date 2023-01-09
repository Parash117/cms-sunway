package com.sunway.cms.dto.student;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String rollNum;

    private String batch;

    @NotNull
    @NotBlank
    private Long facultyId;

    private String facultyName;

    public String getName() {
        return name.trim();
    }
}
