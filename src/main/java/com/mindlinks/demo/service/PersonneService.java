package com.mindlinks.demo.service;


import com.mindlinks.demo.entity.Personne;
import com.mindlinks.demo.mapping.PersonneResponse;
import com.mindlinks.demo.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class PersonneService {


    @Autowired
    PersonneRepository personneRepository;


    public Personne add(Personne p) {


        return personneRepository.save(p);

    }


    public Personne getPersonneByCin(String cin) {
        return personneRepository.getPersonneByCin(cin);
    }


    public Personne update(Personne p) {

        return personneRepository.save(p);

    }


    public void delete(Long id) {

        personneRepository.deleteById(id);

    }


    public List<Personne> getAll() {

        return personneRepository.findAll();

    }


    public List<PersonneResponse> getAllWithAge() {


        List<PersonneResponse> lisPersonneWithAge = new ArrayList<>();

        Collection<Personne> listPersonne = personneRepository.findAll();


        for (Personne p : listPersonne) {


            PersonneResponse personneResponse = new PersonneResponse(p.getId(), p.getNom(), p.getPrenom(), p.getCin(), p.getDateNaissance(), calculeAge(p.getDateNaissance()));

            lisPersonneWithAge.add(personneResponse);

        }


        return lisPersonneWithAge;


    }


    private int calculeAge(Date dateNaissance) {

        Date aujourduit = new Date();
        int age = 0;

        if (dateNaissance != null)
            age = aujourduit.getYear() - dateNaissance.getYear();


        return age;

    }


}
