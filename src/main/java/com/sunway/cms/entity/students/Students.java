package com.sunway.cms.entity.students;

import com.sunway.cms.entity.facutly.Faculty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_STUDENT_ROLLNUM", columnNames = {"rollNum"})
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String rollNum;

    private String batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "FK_STUDENT_FACULTY"))
    private Faculty faculty;

    public Students(Long id) {
        this.id = id;
    }
}
