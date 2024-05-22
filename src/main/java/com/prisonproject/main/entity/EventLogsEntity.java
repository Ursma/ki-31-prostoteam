package com.prisonproject.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event_log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventLogsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "event_type")
    private Integer eventType;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "inmate_id")
    private Integer inmateId;
    @Column(name = "guard_id")
    private Integer guardId;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "guard_id")
    private List<GuardEntity> guradEntityList;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "inmate_id")
    private List<InmateEntity> inmateEntityList;
}
