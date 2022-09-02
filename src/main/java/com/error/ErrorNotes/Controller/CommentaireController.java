package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.*;
import com.error.ErrorNotes.service.CommentaireService;
import com.error.ErrorNotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentaire")

public class CommentaireController {


    @Autowired
    CommentaireService commentaireService;

    @Autowired
    UserService userService;

    @PostMapping("/ajouter/{email}/{password}/{titre}")
    public String ajouter( Commentaire commentaire, @PathVariable("email") String email, @PathVariable("password") String password,@PathVariable("titre") String titre){


        //Authenfication
        if (userService.Connexion(email, password)){

            User use = userService.trouverCompteParEmail(email);
            if (use.getRole().equals(Role.USER)) {
                return " Vous n'est pas autorisé a ajouter un commentaire";
            } else {
                //recuperer le probleme correspondant au titre mis a l'url
                Probleme probleme = userService.touverProblemeParTitre(titre);

                //verfire si le probleme existe
                if (probleme != null){
                    //Recuperer l'id  du probleme
                    Long idProbleme = probleme.getId_probleme();

                    //Recuperer la solution correspondant au probleme

                    Solution solution = userService.trouverSolutionParIdProbleme((idProbleme));

                    //Recuperation de l'user par son email
                    User comptes = userService.trouverCompteParEmail(email);


                    //Recuperation de l'user par son compte
                    User user =userService.trouverUserParCompte(comptes);

                    //creation du commentaire
                    userService.creerCommentaire(commentaire, user, solution);

                    return  "Commentaire ajouter avec succès";
                }else {
                    return "Ce probleme n'existe pas";
                }
            }


        }else {
            return "Accès refusé";
        }

    }
    @PutMapping("/modifier/{id_commentaire}")
    public Commentaire modifier(Commentaire commentaire, @PathVariable Long id_commentaire, @PathVariable String email, @PathVariable String password){


        return  commentaireService.modifier(commentaire,id_commentaire);
    }
    @DeleteMapping("/supprimer/{id_commentaire}")
    public String supprimer( @PathVariable Long id_commentaire){
        commentaireService.supprimer(id_commentaire);
        return "commentaire supprimé";
    }
}
