package com.renato.biblioteca.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.repositories.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	ApostaRepository apostaRepository;
	@Autowired
	ApostadorService apostadorService;
	
	public Aposta gerarAposta(Apostador apostador){
		if(!apostadorService.existe(apostador.getEmail())) {
			apostadorService.salvar(apostador);
		}
		Aposta aposta = new Aposta(null, new Date(), apostadorService.buscar(apostador.getEmail()));
		aposta = apostaRepository.save(aposta);	
		return aposta;
	}

	public List<Aposta> buscarApostasPorEmail(String email) {
		List<Aposta> apostas = apostaRepository.listaPorData(email); 
		return apostas;
	}
}
