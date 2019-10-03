package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMetierImpl implements UserMetier{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listeUser() {
        return userRepository.findAll();
    }
}
