package com.nal95.portfolioforenterprise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enterpriseName;

    private String urlId;
}
