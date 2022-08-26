package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Solution;

import java.util.List;

public interface SolutionService {


    Solution ajouter(Solution solution);
    Solution modifier(Solution solution, Long id_solution);
    String supprimer(Long id_solution);
    List<Solution> afficher();
}
