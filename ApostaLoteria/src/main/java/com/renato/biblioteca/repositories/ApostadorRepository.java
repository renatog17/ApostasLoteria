package com.renato.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.renato.biblioteca.domain.Apostador;

public interface ApostadorRepository extends JpaRepository<Apostador, Integer>{

	@Transactional(readOnly = true)
	Apostador findByEmail(String email);
}
