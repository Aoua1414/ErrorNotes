package com.error.ErrorNotes.Model;

import javax.persistence.*;

public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_probleme;
    private  String titre;
    private  String description;
    private  String technologie;
    private  String methode_de_recherche;
    private  Etats etats;



    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;

}
