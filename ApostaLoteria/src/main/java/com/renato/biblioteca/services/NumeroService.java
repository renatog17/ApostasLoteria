package com.renato.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Numero;
import com.renato.biblioteca.repositories.NumeroRepository;

@Service
public class NumeroService {

	@Autowired
	private NumeroRepository numeroRepository;
	
	public void salvarTodos(List<Numero> numeros) {
		numeroRepository.saveAll(numeros);
	}
}
