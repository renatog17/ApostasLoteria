package com.renato.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostadorDTO;
import com.renato.biblioteca.dto.ApostadorNewDTO;
import com.renato.biblioteca.repositories.ApostadorRepository;
import com.renato.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class ApostadorService {

	@Autowired
	private ApostadorRepository apostadorRepository;
	
	public Apostador findByEmail (String email) {
		Apostador apostador = apostadorRepository.findByEmail(email);
		return apostador;
		//return apostador.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"
				//+ "Email: "+email+", Tipo: "+Apostador.class.getName()));
	}
	
	public Apostador salvar(Apostador apostador) {
		return apostadorRepository.save(apostador);
	}
	
	public void update (Apostador apostador, String email) {
		Apostador newApostador = findByEmail(email);
		apostador.setCpf(newApostador.getCpf());
		apostador.setId(newApostador.getId());
		apostadorRepository.save(apostador);
	}
	
	public Apostador fromDto(ApostadorNewDTO apostadorNewDto) {
		Apostador apostador = new Apostador(null, apostadorNewDto.getEmail(), apostadorNewDto.getNome(), apostadorNewDto.getTelefone(), apostadorNewDto.getCpf());
		return apostador;
	}
	
	public Apostador fromDto(ApostadorDTO apostadorDto) {
		Apostador apostador = new Apostador(null, apostadorDto.getEmail(),apostadorDto.getNome(), apostadorDto.getTelefone(), null);
		return apostador;
	}
	
}
