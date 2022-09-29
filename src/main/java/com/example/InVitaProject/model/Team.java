package com.example.InVitaProject.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "Teams")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String name;
    String stadium;
    double fifaRating;
    int squadSize;
    String nextMatch;
}
