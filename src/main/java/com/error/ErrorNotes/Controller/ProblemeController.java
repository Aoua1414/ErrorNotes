package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probleme")
public class ProblemeController {
@Autowired
    ProblemeService problemeService;
@PostMapping ("/ajouter")
    public Probleme ajouter(@RequestBody Probleme probleme){
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
}
