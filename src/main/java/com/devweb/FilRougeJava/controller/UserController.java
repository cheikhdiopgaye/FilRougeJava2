package com.devweb.FilRougeJava.controller;

import com.devweb.FilRougeJava.Mitiers.UserMetier;
import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.request.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserMetier userMetier;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping(value = "/user",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public boolean addUser(@RequestBody UserForm adduserForm){

        userMetier.addUser(adduserForm.getName(),adduserForm.getUsername(), adduserForm.getEmail(), encoder.encode(adduserForm.getPassword()), adduserForm.getAdresse(),adduserForm.getTelephone(), adduserForm.getProfil(),adduserForm.getImageName());
        return true;
    }

}
