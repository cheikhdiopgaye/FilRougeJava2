package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.*;
import com.devweb.FilRougeJava.repository.ComptebancaireRepository;
import com.devweb.FilRougeJava.repository.PartenaireRepository;
import com.devweb.FilRougeJava.repository.RoleRepository;
import com.devweb.FilRougeJava.repository.UserRepository;
import com.devweb.FilRougeJava.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class PartenaireMetierImpl implements PartenaireMitier {
    @Autowired
    private PartenaireRepository partenaireRepository;
    @Autowired
    private ComptebancaireRepository comptebancaireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public Partenaire addPart(Partenaire part) {
        return  partenaireRepository.save(part);
    }
    @Override
    @Transactional
    public List<Partenaire> liste() {
        return partenaireRepository.findAll();
    }
    @Override
    @Transactional
    public void NewEntreprise(String raisonSocial, String ninea, String adress, String telephon, String etats, String name, String username, String password, String email, String adresse, String telephone, String profil, String etat,String imageName) throws Exception {

        //Ajout partenaire
        Partenaire part= new Partenaire();
        part.setRaisonSocial(raisonSocial);
        part.setNinea(ninea);
        part.setAdress(adress);
        part.setTelephon(telephon);
        part.setEtats(etats);
        partenaireRepository.save(part);
        // Ajout Utlisisateur(admin partenaire)
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAdresse(adresse);
        user.setTelephone(telephone);
        user.setProfil(profil);
        user.setEtat(etat);
        user.setImageName(imageName);
        user.setPartenaire( part);
        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN_PART).orElseThrow(() -> new Exception("User Role not set."));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
        //Ajout compte bancaire
        CompteBancaire cp= new CompteBancaire();
        cp.setSolde(25000);
        cp.setDatecreation(new Date());
        int num=(int)(Math.random()*(999999999)+10);
        cp.setNumeroCompte(num);
        cp.setPartenaire(part);
        comptebancaireRepository.save(cp);
    }
    @Override
    @Transactional
    public void BloquerPartenaire(@PathVariable("id") int id) throws Exception {
          Partenaire partenaire = partenaireRepository.findById(id).orElseThrow(()-> new Exception("id invalide"));
        if (partenaire.getEtats().equals("activé")) {
            partenaire.setEtats("Bloqué");
        }else if (partenaire.getEtats().equals("Bloqué")){
            partenaire.setEtats("activé");
            partenaireRepository.saveAndFlush(partenaire);
        }
    }
}
