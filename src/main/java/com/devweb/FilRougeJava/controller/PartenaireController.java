package com.devweb.FilRougeJava.controller;

import com.devweb.FilRougeJava.Mitiers.PartenaireMitier;
import com.devweb.FilRougeJava.model.CompteBancaire;
import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.repository.ComptebancaireRepository;
import com.devweb.FilRougeJava.repository.PartenaireRepository;

import com.devweb.FilRougeJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {

    @Autowired
    private PartenaireMitier partenaireMitier;
    /*private PartenaireRepository partenaireRepository;
    private ComptebancaireRepository comptebancaireRepository;
    private UserRepository userRepository;*/

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public List<Partenaire> liste(){
        return  partenaireMitier.liste();
    }

    @PostMapping(value = "/add",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public Partenaire addPart(@RequestBody Partenaire part){
        return partenaireMitier.addPart(part);
    }
}
