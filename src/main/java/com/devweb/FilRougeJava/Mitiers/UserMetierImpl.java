package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserMetierImpl implements UserMetier{
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void addUser(String name, String username, String password, String email, String adresse, String telephone, String profil, String imageName) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setAdresse(adresse);
        user.setTelephone(telephone);
        user.setProfil(profil);
        user.setEtat(email);
        user.setImageName(imageName);
        userRepository.save(user);
    }

    @Override
    public List<User> listeUser() {
        return userRepository.findAll();
    }
}
