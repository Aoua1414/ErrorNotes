package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemeRepository extends JpaRepository <Probleme, Long> {

  // @Query("SELECT * FROM probleme WHERE probleme.titre LIKE %?1% " + "OR probleme.description LIKE %?1%")
    List<Probleme> findAll();

}
