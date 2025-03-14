package com.example.importation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "peoples")
public class People {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String datedenaissance;
    private String status;
}
