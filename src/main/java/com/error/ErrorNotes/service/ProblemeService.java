package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Probleme;

import java.util.List;

public interface ProblemeService {


    Probleme ajouter(Probleme probleme);
    Object recherche(String mot_cle);

    String supprimer(Long id_probleme);

    Probleme modifier(Probleme probleme, Long id_probleme);

    List<Probleme> afficher();
}
