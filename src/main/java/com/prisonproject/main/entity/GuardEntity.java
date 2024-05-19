package com.prisonproject.main.entity;

import com.prisonproject.main.enums.GenderTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "guard")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Instant birthday;
    @Column(name = "start_date")
    private Instant startDate;
    @Enumerated
    @Column(name = "gender")
    private GenderTypeEnum gender;
}
