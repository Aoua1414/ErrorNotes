package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.ProblemeService;
import com.error.ErrorNotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {
@Autowired
    ProblemeService problemeService;
@Autowired
    UserService userService;
    @PostMapping ("/ajouter")
    public Probleme ajouter(@RequestBody Probleme probleme){
    System.out.println(probleme.getDescription());
   // userService.ajouter(id_user);
    return problemeService.ajouter(probleme);
}
    @PutMapping("/modifier/{id_probleme}")
    public Probleme modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.modifier(probleme, id_probleme);
}
    @DeleteMapping ("/supprimer/{id_probleme}")
    public String supprimer(Probleme probleme, @PathVariable Long id_probleme){
    return problemeService.supprimer( id_probleme);
}



    @GetMapping("/recherche")
    public Object recherche(String mot_cle){
    return  problemeService.recherche(mot_cle);
    }
}
