package com.error.ErrorNotes.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_probleme;
    @Column(name = "titre", length = 50, nullable = false, unique = true)
    private  String titre;
    private  String description;
    private  String technologie;
    private  String methode_de_recherche;


    @Enumerated(EnumType.STRING)
    private  Etats etats;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;

}
