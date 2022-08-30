package com.error.ErrorNotes.service.Implementation;

import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.Repository.UserRepository;
import com.error.ErrorNotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

    public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User ajouter(User user) {
        return userRepository.save(user);
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
    public boolean connexion(String email, String password) {
        User user= userRepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password)){
            return true;

        }
        else{
        return false;
        }
    }

    // @Override
    //public String seconnecter(User user) {
       // return user.getPassword();
    }

