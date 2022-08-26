package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Repository.CommentaireRepository;
import com.error.ErrorNotes.service.CommentaireService;

import java.util.List;

public class CommentaireServiceImpl implements CommentaireService {

    CommentaireRepository commentaireRepository;


    @Override
    public Commentaire ajouter(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire modifier(Commentaire commentaire, Long id_commentaire) {
        return commentaireRepository.findById(id_commentaire).map(
                c->{
                    c.setMessage(commentaire.getMessage());
                    c.setDate(commentaire.getDate());

                return commentaireRepository.save(c);
                }
        ).orElseThrow(()-> new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public String supprimer(Long id_commentaire) {
        commentaireRepository.deleteById(id_commentaire);

        return "Commentaire supprimé avec succès";
    }

    @Override
    public List<Commentaire> afficher() {
        return commentaireRepository.findAll();
    }
}
