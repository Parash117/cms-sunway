package com.sunway.cms.entity.facutly;

import com.sunway.cms.entity.subjects.Subjects;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String shortCode;

    @Column(columnDefinition = "TEXT")
    private String details;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "FK_FACULTY_SUBJECTS"))
    private List<Subjects> subjectList;

    public Faculty(Long id) {
        this.id = id;
    }
}
