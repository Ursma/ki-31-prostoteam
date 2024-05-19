package com.prisonproject.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cell")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cell_number")
    private Integer cellNumber;
    @Column(name = "current_occupancy")
    private Integer currentOccupancy;
    @Column(name = "capacity")
    private Integer capacity;
}
