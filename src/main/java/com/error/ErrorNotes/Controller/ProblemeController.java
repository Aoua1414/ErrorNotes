package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Configuration.Messages;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.service.ProblemeService;
import com.error.ErrorNotes.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService problemeService;
    @Autowired
    UserService userService;
    @PostMapping ("/ajouter/{email}")
    public ResponseEntity<Object> ajouter(@RequestBody Probleme probleme, @PathVariable("email") String email){



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
    @PutMapping("/modifier/{id_probleme}")
    public Probleme modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.modifier(probleme, id_probleme);
}
    @DeleteMapping ("/supprimer/{id_probleme}")
    public String supprimer(Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.supprimer( id_probleme);
}
    @GetMapping("/recherche/{mot_cle}")
    public Object recherche(@PathVariable String mot_cle){
    return  problemeService.recherche(mot_cle);
    }
}
