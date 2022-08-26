package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Repository.ProblemeRepository;
import com.error.ErrorNotes.service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProblemeServiceImpl implements ProblemeService {

    @Autowired
    ProblemeRepository problemeRepository;

    @Override
    public Probleme ajouter(Probleme probleme) {
        return problemeRepository.save(probleme);
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
