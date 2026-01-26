package com.teamstep.stepbackend.domain.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    @Column(unique = true)
    private String email;
    private Authority authority;

}
