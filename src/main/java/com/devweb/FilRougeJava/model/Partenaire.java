package com.devweb.FilRougeJava.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "partenaire")
public class Partenaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String raisonSocial;

    @NotBlank
    @Size(min = 5, max = 20)
    private String ninea;
    @NotBlank
    @Size(min = 3, max = 50)
    private String adress;
    @NotBlank
    @Size(min = 9, max = 15)
    private String telephon;
    @NotBlank
    @Size(min = 2, max = 10)
    private String etats;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<CompteBancaire> compteBancaires;

    public Partenaire() {
    }

    public Partenaire(@NotBlank @Size(min = 3, max = 50) String raisonSocial, @NotBlank @Size(min = 5, max = 20) String ninea, @NotBlank @Size(min = 3, max = 50) String adress, @NotBlank @Size(min = 9, max = 15) String telephon, @NotBlank @Size(min = 2, max = 10) String etats, List<CompteBancaire> compteBancaires) {
        this.raisonSocial = raisonSocial;
        this.ninea = ninea;
        this.adress = adress;
        this.telephon = telephon;
        this.etats = etats;
        this.compteBancaires = compteBancaires;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    public String getEtats() {
        return etats;
    }

    public void setEtats(String etats) {
        this.etats = etats;
    }

    public List<CompteBancaire> getCompteBancaires() {
        return compteBancaires;
    }

    public void setCompteBancaires(List<CompteBancaire> compteBancaires) {
        this.compteBancaires = compteBancaires;
    }
}
