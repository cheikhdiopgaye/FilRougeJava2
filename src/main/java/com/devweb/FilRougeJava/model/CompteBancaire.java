package com.devweb.FilRougeJava.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compte")
public class CompteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numeroCompte;

    private double solde;

    private Date datecreation;
    @JoinColumn(name = "partenaire", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("comptes")
    private Partenaire partenaire;

    public CompteBancaire() {
    }

    public CompteBancaire(@NotBlank @Size(min = 9, max = 15) int numeroCompte, @NotBlank @Size(max = 50) double solde, Date datecreation, Partenaire partenaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.datecreation = datecreation;
        this.partenaire = partenaire;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }


}
