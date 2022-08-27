package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.ProblemeRepository;
import com.error.ErrorNotes.Repository.UserRepository;
import com.error.ErrorNotes.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/probleme")
public class ProblemeServiceImpl implements ProblemeService {

    @Autowired
    ProblemeRepository problemeRepository;
    UserRepository userRepository;

    @PostMapping("/add")
    @Override
    public Probleme ajouter(Probleme probleme, User id_user)
    {
         User us = new User();
         us.getNom();
         us.getRole();
         userRepository.save(id_user);
        return problemeRepository.save(probleme);
    }



    //Recherche par mot cle
    @Override
    public Object recherche(String mot_cle) {
        if(mot_cle!= null){
            List<Probleme> recherche =problemeRepository.findAll();

            if (recherche.size() != 0){
                return recherche;
            }else {
                return "Desole ce mot est introuvable";
            }
        }
        return problemeRepository.findAll();
    }

    @Override
    public String supprimer(Long id_probleme) {
        problemeRepository.deleteById(id_probleme);
        return "Problème supprimé avec succès";
    }

    @Override
    public Probleme modifier(Probleme probleme, Long id_probleme) {
        return problemeRepository.findById(id_probleme).map(
                p->{
                    p.setTitre(probleme.getTitre());
                    p.setDescription(probleme.getDescription());
                    p.setTechnologie(probleme.getTechnologie());
                    p.setMethode_de_recherche(probleme.getMethode_de_recherche());
                    p.setEtats(probleme.getEtats());

                 return   problemeRepository.save(p);
                }

        ) .orElseThrow(()-> new RuntimeException(" Problème non trouvé"));
    }

    @Override
    public List<Probleme> afficher() {
        return problemeRepository.findAll();
    }
}
