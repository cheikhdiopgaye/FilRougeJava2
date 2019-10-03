package com.devweb.FilRougeJava.repository;

import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    Optional<Partenaire> findByRaisonSocial(String raisoSocial);
    Boolean existsByRaisonSocial(String raisonSocial);
}