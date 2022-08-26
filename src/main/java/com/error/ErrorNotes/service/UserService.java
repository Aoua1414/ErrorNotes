package com.error.ErrorNotes.service;

import com.error.ErrorNotes.Model.User;

import java.util.List;

public interface UserService {

    User ajouter(User user);

    String supprimer(Long id_user);

    User modifier(User user, Long id_user);

    List<User> afficher();
}
