package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Configuration.Messages;
import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "hello", description = "User controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Ajouter un user")
    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouter(@RequestBody User user){

        try {
             return Messages.reponse("Bienvenue "+user.getPrenom()+" "+user.getNom(),HttpStatus.OK,userService.ajouter(user));
        }catch (Exception e){
            return Messages.reponse(e.getMessage(), HttpStatus.OK, null);
        }
    }



    @ApiOperation(value = " ")
    @PostMapping("/connexion/{email}/{password}")
    public Object Connexion(@PathVariable String email, @PathVariable String password){

      return userService.Connexion(email,password);
    }

    @ApiOperation(value = "")
    @PutMapping("/update/{email}/{password}/{id_user}")
    public String modifier( User user, @PathVariable Long id_user, @PathVariable String email, @PathVariable String password){

        User use = userService.trouverCompteParEmail(email);
        if (user.getRole().equals(Role.USER)) {
            return " Vous n'est pas autorisé a modifier un utilisateur";
        }else {
           userService.modifier(user, id_user);


        }
         return " "+user.getPrenom()+" "+user.getNom()+" modifier avec succès";
    }

    @ApiOperation(value = " ")
    @DeleteMapping("/delete/{email}/{password}/{id_user}")
    public  String supprimer(@PathVariable Long id_user, @PathVariable String email, @PathVariable String password){

        if (userService.Connexion(email, password)){

            User user = userService.trouverCompteParEmail(email);
            if (user.getRole().equals(Role.USER)) {
                return "Vous n'est pas autorisé a supprimer un utilisateur";
            }else {
                userService.supprimer(id_user);

            }
        }
        return "Supprimer avec succès";
    }

    @GetMapping("/user/{email}/{password}/")
    public Object afficher(@PathVariable String email, @PathVariable String password) {


        if (userService.Connexion(email, password)) {

            /*if (Connexion(email, password).equals(Role.USER)) {
                return "Vous n'est pas autorisé";
            }else {
                return userService.afficher();
            }*/
            User user = userService.trouverCompteParEmail(email);
            if (user.getRole().equals(Role.USER)) {
                return "Vous n'est pas autorisé";
            }else {
                return userService.afficher();
            }

        }
        return "Accès refusé";

    }


}
