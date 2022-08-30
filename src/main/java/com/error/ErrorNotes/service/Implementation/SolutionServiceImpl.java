package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.ProblemeRepository;
import com.error.ErrorNotes.Repository.SolutionRepository;
import com.error.ErrorNotes.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SolutionServiceImpl implements SolutionService {
   @Autowired
    SolutionRepository solutionRepository;
@Autowired
    ProblemeRepository problemeRepository;
    @Override
    public Solution ajouter(Solution solution, Probleme probleme) {

        //Instanciation de probleme
        Probleme prob = new Probleme();

        solution.setProbleme(probleme);
        return solutionRepository.save(solution);
    }



    @Override
    public Solution modifier(Solution solution, Long id_solution) {

        return solutionRepository.findById (id_solution).map(
                s->{
                    s.setDescription(solution.getDescription());
                    s.setRessources(solution.getRessources());
                    s.setTemps(solution.getTemps());
                    return solutionRepository.save(s);
                }

        ).orElseThrow(()-> new RuntimeException(" Solution non trouvé"));
    }

    @Override
    public String supprimer(Long id_solution) {
        solutionRepository.deleteById(id_solution);
        return "Solution supprimée avec succès";
    }

    @Override
    public List<Solution> afficher() {
        return solutionRepository.findAll();
    }

}
