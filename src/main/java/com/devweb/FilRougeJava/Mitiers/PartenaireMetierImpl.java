package com.devweb.FilRougeJava.Mitiers;

import com.devweb.FilRougeJava.model.Partenaire;
import com.devweb.FilRougeJava.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PartenaireMetierImpl implements PartenaireMitier {
    @Autowired
    private PartenaireRepository partenaireRepository;
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
}
