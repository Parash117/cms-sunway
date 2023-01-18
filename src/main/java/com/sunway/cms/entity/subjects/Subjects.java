package com.sunway.cms.entity.subjects;

import com.sunway.cms.entity.facutly.Faculty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String shortCode;

    private Integer creditHrs;

    @Column(columnDefinition = "TEXT")
    private String details;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "FK_FACULTY_SUBJECTS"))
//    private Faculty faculty;
}
