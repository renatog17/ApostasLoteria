package com.renato.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.repositories.ApostadorRepository;
import com.renato.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class ApostadorService {

	@Autowired
	private ApostadorRepository apostadorRepository;
	
	public Apostador buscar (String email) {
		Optional<Apostador> apostador = apostadorRepository.findById(email);
		return apostador.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"
				+ "Email: "+email+", Tipo: "+Apostador.class.getName()));
	}
}
