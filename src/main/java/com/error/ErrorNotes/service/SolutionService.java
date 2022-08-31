package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;

import java.util.List;

public interface SolutionService {


    Solution ajouter(Solution solution, Probleme probleme);

    Solution modifier(Solution solution, Long id_solution);
    String supprimer(Long id_solution);
    List<Solution> afficher();

    //pour que seuls les deux admins seuls puissent commenter

    Solution verifier(Solution solution);
}
