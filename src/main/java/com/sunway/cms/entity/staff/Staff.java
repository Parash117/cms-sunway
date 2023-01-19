package com.sunway.cms.entity.staff;

import com.sunway.cms.enums.StaffType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;

    @Enumerated(EnumType.STRING)
    private StaffType staffType;


    public Staff(Integer id) {
        this.id = id;
    }
}
