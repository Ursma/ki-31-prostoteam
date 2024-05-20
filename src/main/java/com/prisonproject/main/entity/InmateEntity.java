package com.prisonproject.main.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inmate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InmateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "cell_id")
    private Integer cellId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cell_id", referencedColumnName = "id", insertable=false, updatable=false)
    private CellEntity cellEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "inmate_crime",
            joinColumns = @JoinColumn(name = "inmate_id"),
            inverseJoinColumns = @JoinColumn(name = "crime_id"))
    private List<CrimeEntity> crimeEntityList;
}
