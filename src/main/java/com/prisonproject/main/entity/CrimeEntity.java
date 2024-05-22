package com.prisonproject.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "crime")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CrimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "crime_name")
    private String crimeNumber;
    @Column(name = "durability")
    private Integer durability;
}
