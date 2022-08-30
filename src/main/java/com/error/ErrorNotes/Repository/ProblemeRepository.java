package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemeRepository extends JpaRepository <Probleme, Long> {
    Probleme findByTitre(String titre);
 //   Probleme findByTire(String titre);
    @Query(value = "SELECT * FROM probleme WHERE probleme.titre LIKE %?1% "
            + " OR probleme.description LIKE %?1%"
            + " OR probleme.technologie LIKE %?1%", nativeQuery = true)
    List<Probleme> findAll(String mot_cle);



}
