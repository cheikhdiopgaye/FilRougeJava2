package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.User;

import java.util.List;

public interface UserMetier {
    public void addUser(String name, String username, String password, String email, String adresse, String telephone, String profil, String imageName) throws Exception;
    public List<User> listeUser();
    public void BloquerUser(long id) throws Exception;
    void ajoutCaissier(String name, String username, String password, String email, String adresse, String telephone, String profil, String imageName) throws Exception;
}
