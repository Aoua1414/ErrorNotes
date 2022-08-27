package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Configuration.Messages;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "hello", description = "Population's methods")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "supprimer un element dans la table population")
    @PostMapping("/add")
    public ResponseEntity<Object> ajouter(@RequestBody User user){
        try {
             return Messages.reponse("",HttpStatus.OK,userService.ajouter(user));
        }catch (Exception e){
            return Messages.reponse(e.getMessage(), HttpStatus.OK, null);
        }
    }

    @ApiOperation(value = "supprimer un element dans la table population")
    public User modifier(@RequestBody User user,  Long id_user){

        return userService.modifier(user, id_user);
    }

}
