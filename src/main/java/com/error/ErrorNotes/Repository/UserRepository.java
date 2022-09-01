package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
  //@Query(value = "SELECT user.nom, user.prenom, user.email FROM user WHERE user.email=? AND user.password=? ;", nativeQuery = true)
  //public User Connexion(String email, String password);

    boolean existsByPassword(String password);

    boolean existsByEmail(String email);
    User findByEmail(String email);

  //  User findByCompte(User user);

}
