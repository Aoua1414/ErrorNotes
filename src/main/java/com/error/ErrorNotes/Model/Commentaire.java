package com.error.ErrorNotes.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_commentaire;
    private  String message;
    private  String date;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;


    @ManyToOne
    @JoinColumn(name = "id_solution")
    private  Solution solution;

}
