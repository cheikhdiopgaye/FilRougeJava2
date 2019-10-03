package com.devweb.FilRougeJava.controller;

import com.devweb.FilRougeJava.Mitiers.CompteMetier;
import com.devweb.FilRougeJava.model.Partenaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping(value = "/Compte")
public class ComptebancaireController {
    @Autowired
    public CompteMetier compteMetier;
    @PostMapping(value = "/add",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public boolean addCompte(@RequestBody Partenaire partenaire) throws Exception {
        compteMetier.addCompte(partenaire.getRaisonSocial());
        return true;
    }
}
