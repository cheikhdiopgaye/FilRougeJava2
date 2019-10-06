package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.model.User;

import java.util.List;

public interface PartenaireMitier {
    public Partenaire addPart(Partenaire part);
    public List<Partenaire> liste();
    public void NewEntreprise(String raisonSocial, String ninea, String adress, String telephon, String etats , String name, String username, String password, String email, String adresse, String telephone, String profil, String etat, String imageName) throws Exception;
    public void BloquerPartenaire(int id) throws Exception;
}
