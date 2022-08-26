package com.error.ErrorNotes.Controller;

import com.error.ErrorNotes.Autres.Messages;
import com.error.ErrorNotes.Model.Role;
import com.error.ErrorNotes.Model.User;
import com.error.ErrorNotes.service.UserService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> ajouter(@RequestBody User user){
        try {
             return Messages.reponse("",HttpStatus.OK,userService.ajouter(user));
        }catch (Exception e){
            return Messages.reponse(e.getMessage(), HttpStatus.OK, null);
        }
    }

    public User modifier(@RequestBody User user,  Long id_user){

        return userService.modifier(user, id_user);
    }

}
