package com.error.ErrorNotes.Model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Solution {

    private  Long id_solution;
    private  String description;
    private  String ressources;
    private  String temps;




    @ManyToOne
    @JoinColumn(name = "id_probleme")
    private  Probleme probleme;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;
}
