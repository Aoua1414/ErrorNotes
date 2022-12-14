package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Configuration.Messages;
import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.CommentaireService;
import com.error.ErrorNotes.service.ProblemeService;
import com.error.ErrorNotes.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService problemeService;
    @Autowired
    UserService userService;

    @Autowired
    CommentaireService commentaireService;
    @PostMapping ("/ajouter/{email}")
    public ResponseEntity<Object> ajouter(Probleme probleme, @PathVariable("email") String email){



try {
    return Messages.reponse(null,HttpStatus.OK, problemeService.ajouter(probleme,email)) ;
}catch (Exception e){
    return Messages.reponse("eeeeeeeeeeeeeeeerrrrrrrrrr", HttpStatus.OK, null) ;



}






/*
        Probleme titre = problemeService.VerifierProblemeParTitre(probleme.getTitre());

        //Verifier si le  titre du probleme existe
        if (titre !=null){
            //recupere l'id du probleme
           // Long id_probleme = titre.getId_probleme();
           return "Ce probleme existe deja";
        }
        else {
            return problemeService.ajouter(probleme);
        }*/
   // userService.ajouter(id_user);

}
    @PutMapping("/modifier/{email}/{password}/{id_probleme}")
    public String modifier(Probleme probleme, @PathVariable Long id_probleme, @PathVariable String email, @PathVariable String password){

        if (userService.Connexion(email, password)) {
            User use = userService.trouverCompteParEmail(email);
            if (use.getRole().equals(Role.USER)) {
                return " Vous n'est pas autoris?? a modifier un utilisateur";
            } else {
                problemeService.modifier(probleme, id_probleme);
                return "Probleme modifier avec succ??s";

            }
        }            return "Acc??s refus??";

    }
    @DeleteMapping ("/supprimer/{email}/{password}/{id_probleme}")
    public String supprimer(Probleme probleme, @PathVariable Long id_probleme,@PathVariable String email, @PathVariable String password){

        if (userService.Connexion(email, password)) {
            User use = userService.trouverCompteParEmail(email);
            if (use.getRole().equals(Role.USER)) {
                return " Vous n'est pas autoris?? a supprimer  un probleme";
            }else {
                problemeService.supprimer(id_probleme);
            }
            return "Probleme supprimer avec succ??s";
        }
        return "Acc??s refus??";

    }
    @GetMapping("/recherche/{mot_cle}")
    public Object recherche(@PathVariable String mot_cle ){

          return   problemeService.recherche(mot_cle);

    }

    @GetMapping("/liste")
    public  List<Probleme> afficher(){
        return  problemeService.afficher();
    }



}
