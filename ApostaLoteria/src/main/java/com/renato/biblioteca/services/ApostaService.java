package com.renato.biblioteca.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.domain.Numero;
import com.renato.biblioteca.repositories.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	ApostaRepository apostaRepository;
	@Autowired
	ApostadorService apostadorService;
	@Autowired
	NumeroService numeroService;
	
	public Aposta gerarAposta(String email){
		Aposta aposta = new Aposta(null, System.currentTimeMillis(), apostadorService.buscar(email));
		List<Numero> numeros = gerarNumerosAleatorios(8, aposta);
		aposta.getNumeros().addAll(numeros);
		aposta = apostaRepository.save(aposta);
		numeroService.salvarTodos(numeros);
		//aposta.setNumeros(gerarNumerosAleatorios(8, aposta));	
		return aposta;
	}

	public List<Aposta> buscarApostasPorEmail(String email) {
		Apostador apostador = apostadorService.buscar(email);
		List<Aposta> apostas = apostador.getApostas(); 
		return apostas;
	}
	
	private static List<Numero> gerarNumerosAleatorios(int qtdNumeros, Aposta aposta) {
		Random rd = new Random();
		Set<Integer> numerosAleatorios = new HashSet<>();
		while(numerosAleatorios.size()<6) {
			numerosAleatorios.add(rd.nextInt(60)+1);
		}
		List<Numero> numeros = new ArrayList<>();
		for (Integer integer : numerosAleatorios) {
			numeros.add(new Numero(null, integer, aposta));
		}
		return numeros;
	}
}
