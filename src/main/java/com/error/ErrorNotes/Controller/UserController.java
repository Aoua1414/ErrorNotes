package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Configuration.Messages;
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
             return Messages.reponse(user.getPrenom(),HttpStatus.OK,userService.ajouter(user));
        }catch (Exception e){
            return Messages.reponse(e.getMessage(), HttpStatus.OK, null);
        }
    }



    @ApiOperation(value = " ")
    @PostMapping("/connexion/{email}/{password}")
    public boolean Connexion(@PathVariable String email, @PathVariable String password){

      return userService.Connexion(email,password);
    }

    @ApiOperation(value = "")
    @PutMapping("/update/{id_user}")
    public User modifier(@RequestBody User user, @PathVariable Long id_user){

        return userService.modifier(user, id_user);
    }

    @ApiOperation(value = " ")
    @DeleteMapping("/delete/{id_user}")
    public  String supprimer(@PathVariable Long id_user){
        userService.supprimer(id_user);
        return "Supprimer avec succès";
    }

}
