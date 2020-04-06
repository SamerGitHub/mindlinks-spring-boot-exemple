package com.mindlinks.demo.repository;


import com.mindlinks.demo.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {

    public Personne getPersonneByCin(String cin);

    public Collection<Personne> findByCinIsNull();



}
