package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;
    @PostMapping("/ajouter")
    public Solution ajouter(@RequestBody Solution solution){
        return solutionService.ajouter(solution);
    }
    @DeleteMapping("/supprimer")
    public String supprimer (@PathVariable Long id_solution){
        return solutionService.supprimer(id_solution);
    }
    @PutMapping("/modifier")
    public Solution modifier(Solution solution,@PathVariable Long id_solution){
        return solutionService.modifier(solution,id_solution);
    }

    }
