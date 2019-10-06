package com.devweb.FilRougeJava.controller;
import com.devweb.FilRougeJava.Mitiers.UserMetier;
import com.devweb.FilRougeJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserMetier userMetier;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping(value = "/AddUser",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMINPART')")
    public boolean addUser(@RequestBody User user) throws Exception {
        userMetier.addUser(user.getName(),user.getUsername(), encoder.encode(user.getPassword()), user.getEmail(), user.getAdresse(),user.getTelephone(), user.getProfil(),user.getImageName());
        return true;
    }
    @GetMapping(value = "/listeuser")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public List<User> listeUser(){
       return userMetier.listeUser();
    }
    @PutMapping(value = "/autorisation/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINPART')")
    public  String BloquerUser(@PathVariable("id") User user) throws Exception {
        userMetier.BloquerUser(user.getId());
        return "Utilisateur bloqué ou activé";
    }
    @PostMapping(value = "/addCaissier",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public boolean ajoutCaissier(@RequestBody User caissier) throws Exception {
        userMetier.ajoutCaissier(caissier.getName(),caissier.getUsername(), encoder.encode(caissier.getPassword()), caissier.getEmail(), caissier.getAdresse(),caissier.getTelephone(), caissier.getProfil(),caissier.getImageName());
        return true;
    }
}
