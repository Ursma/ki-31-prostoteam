package com.prisonproject.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

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
    private LocalDate birthday;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "shift")
    private Integer shift;
    @Column(name = "cell_id")
    private Integer cellId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cell_id", referencedColumnName = "id", insertable=false, updatable=false)
    private CellEntity cellEntity;
}
