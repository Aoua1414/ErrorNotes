package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long > {
}
