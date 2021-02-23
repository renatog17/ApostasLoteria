package com.renato.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostadorDTO;
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
	
	public boolean existe(String email) {
		if(apostadorRepository.existsById(email)) {
			return true;
		}
		return false;
	}
	
	public Apostador salvar(Apostador apostador) {
		return apostadorRepository.save(apostador);
	}
	
	public Apostador fromDto(ApostadorDTO apostadorDto) {
		Apostador apostador = new Apostador(apostadorDto.getEmail(), apostadorDto.getNome(), apostadorDto.getTelefone(), apostadorDto.getCpf());
		return apostador;
	}
}
