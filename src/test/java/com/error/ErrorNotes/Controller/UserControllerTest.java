package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.UserRepository;
import com.error.ErrorNotes.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController userController;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService service;
    @Test
    void ajouter() {

        User us = new User();

        us.setPrenom("Aly D");
        us.setNom("KONTE");
        us.setEmail("alydkonte19@gmail.com");
        us.setRole(Role.USER_ADMIN);
        us.setContact("68123608");
        us.setPassword("azerty");

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
    void modifier() {

      /* User us = new User();


        us.setId_user(1L);
        us.setPrenom("Aly DDD");
        us.setNom("KONTE");
        us.setEmail("alydkonte@gmail.com");
        us.setRole(Role.USER_ADMIN);
        us.setContact("68123607");
        us.setPassword("azerty");

        User userSave = userController.modifier(us, 1L, us.getEmail(), us.getPassword());

        assertNotNull(userSave);
        assertEquals(us.getPrenom(), userSave.getPrenom());
        assertEquals(us.getNom(), userSave.getNom());
        assertEquals(us.getEmail(), userSave.getEmail());
        assertEquals(us.getPassword(), userSave.getPassword());
        assertEquals(us.getRole(),userSave.getRole() );
        assertEquals(us.getContact(), userSave.getContact());
        assertEquals(us.getPassword(), userSave.getPassword());
       // if(userRepository.findByEmail(us.getEmail())==null){
*/


        User us = new User();

        us.setPrenom("Aly D");
        us.setNom("KONTE");
        us.setEmail("alydkonte19@gmail.com");
        us.setRole(Role.USER_ADMIN);
        us.setContact("68123608");
        us.setPassword("azerty");





    }

    @Test
    void supprimer() {
    }

    @Test
    void afficher() {
    }
}