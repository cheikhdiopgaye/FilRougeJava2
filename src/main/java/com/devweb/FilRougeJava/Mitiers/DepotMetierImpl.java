package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.CompteBancaire;
import com.devweb.FilRougeJava.model.Depot;
import com.devweb.FilRougeJava.repository.ComptebancaireRepository;
import com.devweb.FilRougeJava.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
public class DepotMetierImpl implements  DepotMetier {
    @Autowired
    public DepotRepository depotRepository;
    @Autowired
    public ComptebancaireRepository comptebancaireRepository;
    @Override
    @Transactional
    public boolean newDepot(double montant, int numeroCompte) throws Exception {
        Depot depot= new Depot();
        CompteBancaire c=  comptebancaireRepository.findByNumeroCompte(numeroCompte).orElseThrow(
                ()->new Exception("Ce compte n'existe pas !")
        );
        depot.setDatedepot(new Date());
        depot.setCompteBancaire(c);
        c.setSolde(c.getSolde()+montant);
        return true;
    }
}
