package com.error.ErrorNotes.Model;

import javax.persistence.*;
import java.util.Date;

public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_solution;
    private  String message;
    private  String date;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;


    @ManyToOne
    @JoinColumn(name = "id_solution")
    private  Solution solution;

}
