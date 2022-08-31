package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentaireService {


    Commentaire ajouter (Commentaire commentaire);

    Commentaire modifier(Commentaire commentaire, Long id_commentaire);

    String supprimer(Long id_commentaire);

   List<Commentaire> afficher();




}
