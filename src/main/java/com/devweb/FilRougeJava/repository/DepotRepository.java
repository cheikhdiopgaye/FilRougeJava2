package com.devweb.FilRougeJava.repository;

import com.devweb.FilRougeJava.model.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepotRepository extends JpaRepository<CompteBancaire, Integer> {

}