package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.UserRepository;

import java.util.List;

public interface ProblemeService {

    Probleme ajouter(Probleme probleme, String email);
    //Probleme touverProblemeParTitre(String titre);
    Probleme VerifierProblemeParTitre(String titre);

    Probleme trouverParSolution(String solution);

    Object recherche(String mot_cle);

    String supprimer(Long id_probleme);

    Probleme modifier(Probleme probleme, Long id_probleme);

    List<Probleme> afficher();
}
