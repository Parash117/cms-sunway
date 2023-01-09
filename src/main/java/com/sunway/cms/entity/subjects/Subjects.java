package com.sunway.cms.entity.subjects;

import lombok.*;

import javax.persistence.*;

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
}
