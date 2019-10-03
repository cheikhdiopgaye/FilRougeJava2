package com.devweb.FilRougeJava.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Depot")
public class Depot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double montant;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datedepot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private  CompteBancaire compteBancaire;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private  User user;

    public Depot() {
    }

    public Depot(int montant, Date datedepot, CompteBancaire compteBancaire, User user) {
        this.montant = montant;
        this.datedepot = datedepot;
        this.compteBancaire = compteBancaire;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
