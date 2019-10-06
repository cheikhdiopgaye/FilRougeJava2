package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.Depot;

import java.util.List;

public interface DepotMetier {
    public  boolean newDepot(double montant, int numeroCompte) throws Exception;
    public List<Depot> listeDepot();
}
