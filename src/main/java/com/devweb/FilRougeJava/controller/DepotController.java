package com.devweb.FilRougeJava.controller;
import com.devweb.FilRougeJava.Mitiers.DepotMetier;
import com.devweb.FilRougeJava.model.Depot;
import com.devweb.FilRougeJava.request.DepotForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/depot")
public class DepotController {
    @Autowired
    private DepotMetier depotMetier;
    @PostMapping(value = "/add",consumes= {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public  boolean newDepot(@RequestBody DepotForm depotForm) throws Exception {
      /* if(depotMetier.existsByNumeroCompte(depotForm.getNumeroCompte())) {
           System.out.println("Ce compte n'existe pas");
        }*/
        depotMetier.newDepot( depotForm.getMontant(), depotForm.getNumeroCompte());
        return true;
    }
    @PutMapping(value = "/autorisation/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public List<Depot> listeDepot(){
       return depotMetier.listeDepot();
    }

}
