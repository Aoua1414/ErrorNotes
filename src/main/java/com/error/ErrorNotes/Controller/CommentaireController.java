package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaire")

public class CommentaireController {


    @Autowired
    CommentaireService commentaireService;

    @PostMapping("/ajouter")
    public Commentaire ajouter(@RequestBody Commentaire commentaire){
        return commentaireService.ajouter(commentaire);
    }
    @PutMapping("/modifier/{id_commentaire}")
    public Commentaire modifier(@RequestBody Commentaire commentaire, @PathVariable Long id_commentaire){
        return  commentaireService.modifier(commentaire,id_commentaire);
    }
    @DeleteMapping("/supprimer/{id_commentaire}")
    public String supprimer( @PathVariable Long id_commentaire){
        commentaireService.supprimer(id_commentaire);
        return "commentaire supprimé";
    }
}
