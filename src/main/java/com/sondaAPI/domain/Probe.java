package com.sondaAPI.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Probe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private ProbeDirection direction;
    private LocalDateTime created;
    private LocalDateTime update;
    private LocalDateTime landing;

    private Long planetId;
}
