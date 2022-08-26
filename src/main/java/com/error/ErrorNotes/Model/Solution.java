package com.error.ErrorNotes.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_solution;
    private  String description;
    private  String ressources;
    private  String temps;




    @ManyToOne
    @JoinColumn(name = "id_probleme")
    private  Probleme probleme;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private  User user;
}
