package com.error.ErrorNotes.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_user;
    private  String nom;
    private  String prenom;
    private  String contact;
    private  String email;
    private  String password;
    private  String email;

    @Enumerated(EnumType.STRING) //
    private  Role role;

}
