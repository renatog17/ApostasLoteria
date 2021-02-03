package com.renato.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.biblioteca.domain.Numero;

public interface NumeroRepository extends JpaRepository<Numero, Integer>{

}