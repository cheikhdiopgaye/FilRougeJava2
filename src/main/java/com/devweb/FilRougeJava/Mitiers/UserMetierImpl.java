package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.Role;
import com.devweb.FilRougeJava.model.RoleName;
import com.devweb.FilRougeJava.model.User;
import com.devweb.FilRougeJava.repository.RoleRepository;
import com.devweb.FilRougeJava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
@Service
public class UserMetierImpl implements UserMetier{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    @Transactional
    public void addUser(String name, String username, String password, String email, String adresse, String telephone, String profil,String imageName) throws Exception {
        User users = new User();
        users.setName(name);
        users.setUsername(username);
        users.setPassword(password);
        users.setEmail(email);
        users.setAdresse(adresse);
        users.setTelephone(telephone);
        users.setProfil(profil);
        users.setEtat("activé");
        users.setImageName(imageName);
        if (users.getProfil().equals("admin")){
            Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new Exception("Le role admin n'a pas été affecté à l'utilisateur"));
            users.setRoles(Collections.singleton(userRole));
        } else if (users.getProfil().equals("user")){
            Role userRole = roleRepository.findByName(RoleName.ROLE_UTILISATEUR).orElseThrow(() -> new Exception("Le role Utilisateur n'a pas été affecté à l'utilisateurUser Role not seté t."));
            users.setRoles(Collections.singleton(userRole));
        }
        userRepository.save(users);
    }
    @Override
    @Transactional
    public void ajoutCaissier(String name, String username, String password, String email, String adresse, String telephone, String profil, String imageName) throws Exception{
        User caissier = new User();
        caissier.setName(name);
        caissier.setUsername(username);
        caissier.setPassword(password);
        caissier.setEmail(email);
        caissier.setAdresse(adresse);
        caissier.setTelephone(telephone);
        caissier.setProfil(profil);
        caissier.setEtat("activé");
        caissier.setImageName(imageName);
        Role userRole = roleRepository.findByName(RoleName.ROLE_CAISSIER).orElseThrow(() -> new Exception("Le role caissier n'a pas été affecté à l'utilisateur"));
        caissier.setRoles(Collections.singleton(userRole));
        userRepository.save(caissier);
    }

    @Override
    public List<User> listeUser() {
        return userRepository.findAll();
    }

    public void BloquerUser(@PathVariable("id") long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(()-> new Exception("id invalide"));
        if (user.getEtat().equals("activé")) {
            user.setEtat("Bloqué");
        }else if (user.getEtat().equals("Bloqué")){
            user.setEtat("activé");
            userRepository.save(user);
        }
    }
}
