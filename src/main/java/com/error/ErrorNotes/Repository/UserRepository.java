package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPassword(String password);

    boolean existsByEmail(String email);

    public User findByEmail(String email);
}
