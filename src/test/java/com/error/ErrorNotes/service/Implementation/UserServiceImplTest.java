package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void ajouter() {
        User us = new User();
        us.setPrenom("Aly");
        us.setNom("KONTE");
        us.setEmail("alykonte19@gmail.com");
        us.setRole(Role.USER_ADMIN);
        us.setContact("76621307");
        us.setPassword("1234567");

        User userSave = userRepository.save(us);

        assertNotNull(userSave);
        assertEquals(us.getPrenom(), userSave.getPrenom());
        assertEquals(us.getNom(), userSave.getNom());
        assertEquals(us.getEmail(), userSave.getEmail());
        assertEquals(us.getPassword(), userSave.getPassword());
        assertEquals(us.getRole(),userSave.getRole() );
        assertEquals(us.getContact(), userSave.getContact());
        assertEquals(us.getPassword(), userSave.getPassword());
    }

    @Test
    void creerCommentaire() {
    }

    @Test
    void connexion() {
    }

    @Test
    void creerSolution() {
    }

    @Test
    void afficher() {
    }
}