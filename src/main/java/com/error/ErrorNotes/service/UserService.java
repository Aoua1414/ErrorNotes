package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User ajouter(User user);
    Commentaire creerCommentaire (Commentaire commentaire,User user, Solution solution);

    boolean Connexion(String email, String password);

    User trouverCompteParEmail(String email);
    User trouverUserParCompte(User user);
    Probleme trouverProblemeParId(Long id);
    Solution creerSolution(Solution solution, Probleme probleme);
    Solution trouverSolutionParIdProbleme(Long id_probleme);
    User Deconnexion(String email, String password);

    String supprimer(Long id_user);

    User modifier(User user, Long id_user);

    List<User> afficher();

    Probleme touverProblemeParTitre(String titre);
}
