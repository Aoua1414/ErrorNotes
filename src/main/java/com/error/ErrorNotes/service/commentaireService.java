package com.error.ErrorNotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentaireService {

    @Autowired

    Commentaire ajouter(Commentaire commentaire);

}
