package com.error.ErrorNotes.Autres;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Messages {

    public static ResponseEntity<Object> reponse(String message, HttpStatus status, Object object){

        Map<String, Object> map = new HashMap<>();
        map.put("Message", message);
        map.put("status", status.value());
        map.put("data", object);
        return new ResponseEntity<Object>(map, status);
    }
}
