package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Etats;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.ProblemeRepository;
import com.error.ErrorNotes.Repository.UserRepository;
import com.error.ErrorNotes.service.ProblemeService;
import com.error.ErrorNotes.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProblemeServiceImplTest {
    @Autowired
    ProblemeService problemeService;

    @Autowired
    ProblemeRepository problemeRepository;

    @Autowired
    UserRepository userRepository;
    @Test
    void ajouter() {
        if (userRepository.existsByEmail("alydkonte19@gmail.com") && userRepository.existsByPassword("azerty")){

            String titre = "titre1";
            String description ="Erreur de bean";
            String technologie = "Java";
            String methode_de_recherche = "google";
            String etats ="ENCOURS";
            User us = new User();

            Probleme po = new Probleme();
            po.setTitre(titre);
            po.setDescription(description);
            po.setTechnologie(technologie);
            po.setMethode_de_recherche(methode_de_recherche);
            po.setEtats(Etats.ENCOURS);
            problemeService.ajouter(po, us.getEmail());

        }

    }

    @Test
    void recherche() {
    }

    @Test
    void supprimer() {
    }

    @Test
    void modifier() {
    }

    @Test
    void afficher() {
    }
}