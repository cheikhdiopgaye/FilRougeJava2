package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.User;

import java.util.List;

public interface UserMetier {
    public User addUser(User user);
    public List<User> listeUser();
}
