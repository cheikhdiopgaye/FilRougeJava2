package com.devweb.FilRougeJava.repository;


import com.devweb.FilRougeJava.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {

}