package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.Partenaire;

import java.util.List;

public interface PartenaireMitier {
    public Partenaire addPart(Partenaire part);
    public List<Partenaire> liste();
}
