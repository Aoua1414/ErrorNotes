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

@Api(value = "hello", description = "Population's methods")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Ajouter un user")
    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouter(@RequestBody User user){
        try {
             return Messages.reponse("",HttpStatus.OK,userService.ajouter(user));
        }catch (Exception e){
            return Messages.reponse(e.getMessage(), HttpStatus.OK, null);
        }
    }

    @ApiOperation(value = "")
    public User modifier(@RequestBody User user, @PathVariable Long id_user){

        return userService.modifier(user, id_user);
    }

    @PostMapping("/connexion")
    public boolean connexion(String email, String password){
        return userService.connexion(email,password);
    }
}
