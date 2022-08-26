package com.error.ErrorNotes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Long id_user;
    private  String nom;
    private  String prenom;
    private  String contact;
    private  Role role;

}
