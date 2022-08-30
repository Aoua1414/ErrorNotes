package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User ajouter(User user);

    String supprimer(Long id_user);

    User modifier(User user, Long id_user);

    List<User> afficher();

     boolean connexion( String email, String password);

}
