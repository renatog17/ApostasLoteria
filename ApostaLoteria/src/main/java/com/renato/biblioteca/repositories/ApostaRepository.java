package com.renato.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renato.biblioteca.domain.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

	@Query("SELECT a FROM Aposta a WHERE a.apostador.email = :email ORDER BY a.data")
	List<Aposta> listaPorData(@Param("email")String email);
}
