package com.devweb.FilRougeJava.repository;

import com.devweb.FilRougeJava.model.CompteBancaire;

import com.devweb.FilRougeJava.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ComptebancaireRepository extends JpaRepository<CompteBancaire, Integer> {
    Optional<CompteBancaire> findByNumeroCompte(int numeroCompte);
    Boolean existsByNumeroCompte(int numeroCompte);
}