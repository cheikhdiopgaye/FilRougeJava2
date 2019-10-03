package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.CompteBancaire;
import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.repository.ComptebancaireRepository;
import com.devweb.FilRougeJava.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class CompteMetierImpl implements CompteMetier {
    @Autowired
    public ComptebancaireRepository comptebancaireRepository;
    @Autowired
    public PartenaireRepository partenaireRepository;

    @Override
    @Transactional
    public boolean addCompte( String raisonSocial) throws Exception {
        CompteBancaire compte= new CompteBancaire();
        Partenaire part=partenaireRepository.findByRaisonSocial(raisonSocial).orElseThrow(
                ()->new Exception("Ce partenaire n'existe pas !")
        );
        compte.setDatecreation(new Date());
        compte.setSolde(25000);
        compte.setNumeroCompte(50000000);
        compte.setPartenaire(part);
        comptebancaireRepository.save(compte);
         return true;
    }
}
