package com.renato.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.biblioteca.domain.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

}
