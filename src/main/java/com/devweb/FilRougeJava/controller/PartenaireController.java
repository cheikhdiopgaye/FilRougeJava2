package com.devweb.FilRougeJava.controller;

import com.devweb.FilRougeJava.Mitiers.PartenaireMitier;
import com.devweb.FilRougeJava.model.CompteBancaire;
import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.repository.ComptebancaireRepository;
import com.devweb.FilRougeJava.repository.PartenaireRepository;

import com.devweb.FilRougeJava.repository.UserRepository;
import com.devweb.FilRougeJava.request.AddEntrepriseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {

    @Autowired
    private PartenaireMitier partenaireMitier;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public List<Partenaire> liste(){
        return  partenaireMitier.liste();
    }

    @PostMapping(value = "/add",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public Partenaire addPart(@RequestBody Partenaire part){
        return partenaireMitier.addPart(part);
    }

    @PostMapping(value = "/Entreprise",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public boolean NewEntreprise(@RequestBody AddEntrepriseForm addEntrepriseForm) throws Exception{
        partenaireMitier.NewEntreprise(addEntrepriseForm.getRaisonSocial(), addEntrepriseForm.getNinea(), addEntrepriseForm.getAdress(),addEntrepriseForm.getTelephon(),addEntrepriseForm.getEtats(),addEntrepriseForm.getName(),addEntrepriseForm.getUsername(),encoder.encode(addEntrepriseForm.getPassword()),addEntrepriseForm.getEmail(),addEntrepriseForm.getAdresse(),addEntrepriseForm.getTelephone(),addEntrepriseForm.getProfil(),addEntrepriseForm.getEtat(),addEntrepriseForm.getImageName());
        return true;
    }
    @PutMapping(value = "/autorisation/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public  String BloquerPartenaire(@PathVariable("id") Partenaire partenaire) throws Exception {
       partenaireMitier.BloquerPartenaire(partenaire.getId());
       return "Partenaire bloqué ou activé";
    }
}
