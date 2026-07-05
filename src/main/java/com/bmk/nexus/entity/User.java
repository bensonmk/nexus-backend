package com.bmk.nexus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<JobApplication> jobApplications;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;
}
