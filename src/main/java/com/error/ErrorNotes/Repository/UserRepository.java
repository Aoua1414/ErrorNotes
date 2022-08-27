package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
