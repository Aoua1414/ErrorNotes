package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.SolutionService;
import com.error.ErrorNotes.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;

    @Autowired
    UserService userService;
    @ApiOperation(value = "Ajout de solution")
    @PostMapping("/ajouter/{email}/{password}/{titre}")
    public String ajouter( Solution solution, @PathVariable String email ,@PathVariable String password ,@PathVariable  String titre){

      //Recuperer le probleme sur laquel la solution doit être postée
        Probleme  prob = userService.touverProblemeParTitre(titre);

        //Verifier si le probleme existe ou pas
        if (prob != null){
            //recuperation de l'id du probleme
            Long idPro = prob.getId_probleme();

            //recuperer l'id de l'utilisateur qui a posté le probleme

            Long id_userProbleme = userService.trouverProblemeParId(idPro).getUser().getId_user();

            //Recuperer le compte de l'utilisateur qui veut résoudre le probleme par son email

            User compte = userService.trouverCompteParEmail(email);

            //Recuperer l'id de l'user qui veut poster une solution

            Long id_useSolution = userService.trouverUserParCompte(compte).getId_user();
            //si email et password de l'user sont corrects

            if (userService.Connexion(email,password) && id_userProbleme.equals(id_useSolution)){

                if (userService.trouverSolutionParIdProbleme(idPro) == null){

                    //creation de la solution
                    Solution solu = userService.creerSolution(solution, prob);
                    //solu.setProbleme(prob);
                    return  "Solution ajouter avec succès";
                }
                else {
                    return " Ce probleme a été déjà";
                }
            }else {
                return  " Acces refusé";
            }

        }else {
            return "Ce probleme n'existe pas";
        }

    }


    @ApiOperation(value = "Ajout de solution")
    @DeleteMapping("/supprimer")
    public String supprimer (@PathVariable Long id_solution){


        return solutionService.supprimer(id_solution);
    }
    @PutMapping("/modifier")
    public Solution modifier(Solution solution,@PathVariable Long id_solution){
        return solutionService.modifier(solution,id_solution);
    }

    }
