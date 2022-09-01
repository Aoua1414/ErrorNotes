package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.Commentaire;
import com.error.ErrorNotes.Model.Probleme;
import com.error.ErrorNotes.Model.Solution;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.ProblemeRepository;
import com.error.ErrorNotes.Repository.SolutionRepository;
import com.error.ErrorNotes.Repository.UserRepository;
import com.error.ErrorNotes.service.CommentaireService;
import com.error.ErrorNotes.service.SolutionService;
import com.error.ErrorNotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentaireService commentaireService;

    @Autowired
    ProblemeRepository problemeRepository;

    @Autowired
    SolutionService solutionService;

    @Autowired
    SolutionRepository solutionRepository;
    @Override
    public User ajouter(User user) {
      //String mdp = user.getPassword();
        //user.setPassword(passwordEncoder.encode(mdp));
        return userRepository.save(user);
    }

    @Override
    public Commentaire creerCommentaire(Commentaire commentaire, User user, Solution solution) {

        //Attribuer la date actuelle au commentaire

        commentaire.setDate(commentaire.getDate());

        //Attribution de la solution au probleme
        commentaire.setSolution(solution);

        //Attribution de l'user au commentaire
        commentaire.setUser(user);
        return commentaireService.ajouter(commentaire);
    }

    @Override
    public boolean Connexion(String email, String password) {
        if (userRepository.existsByEmail(email) && userRepository.existsByPassword(password)) {
            System.out.println("Connecter avec succès");
            return true;
        }
        return false;
    }

    @Override
    public User trouverCompteParEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User trouverUserParCompte(User user) {
        return userRepository.save(user);
    }

    @Override
    public Probleme trouverProblemeParId(Long id) {
        return problemeRepository.findById(id).get();
    }

    @Override
    public Solution creerSolution(Solution solution, Probleme probleme) {
        return  solutionService.ajouter(solution,probleme);
    }

    @Override
    public Solution trouverSolutionParIdProbleme(Long id_probleme) {

        return solutionRepository.FIND_SOLUTION_BY_ID_PROBLEME(id_probleme);
    }
      /*  if (userRepository.existsByEmail(email)==false && userRepository.existsByPassword(password)==false){

            return "Cet email n'existe pas";



        }else {
                userRepository.findAll();
            return "est connecter avec succès";
        }
    */

    @Override
    public User Deconnexion(String email, String password) {
        return null;
    }

    @Override
    public String supprimer(Long id_user) {
        userRepository.deleteById(id_user);
        return "User supprimé avec succès";
    }

    @Override
    public User modifier(User user, Long id_user) {
        return userRepository.findById(id_user).map(
                u->{
                    u.setNom(user.getNom());
                    u.setPrenom(user.getPrenom());
                    u.setContact(user.getContact());
                    u.setRole(user.getRole());
                    return userRepository.save(u);
                }

        ).orElseThrow(()-> new RuntimeException("User non trouvé"));
    }

    @Override
    public List<User> afficher() {
        return userRepository.findAll();
    }

    @Override
    public Probleme touverProblemeParTitre(String titre) {
        return problemeRepository.findByTitre(titre);
    }
}
