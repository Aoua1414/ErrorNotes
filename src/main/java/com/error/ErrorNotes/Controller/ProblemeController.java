package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.ProblemeService;
import com.error.ErrorNotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {
@Autowired
    ProblemeService problemeService;
@Autowired
    UserService userService;
@PostMapping ("/ajouter/{email}/{password}")
    public String ajouter(@RequestBody Probleme probleme,@PathVariable("email") String email, @PathVariable("password") String password) {
    if (userService.connexion(email, password) ){
        problemeService.ajouter(probleme);

        return "Problème ajouté avec succès";
    }
        return "Connexion échouée";

}
@PutMapping("/modifier/{id_probleme}")
    public Probleme modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.modifier(probleme, id_probleme);
}
@DeleteMapping ("/supprimer/{id_probleme}")
    public String supprimer(Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.supprimer(id_probleme);

    //@PostMapping("/se connecter/{password}")
           // public String seconnecter(probleme, @PathVariable String password){
       // return problemeServic
    }
}

