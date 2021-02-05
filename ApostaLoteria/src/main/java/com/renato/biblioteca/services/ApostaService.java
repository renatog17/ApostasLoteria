package com.renato.biblioteca.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Numero;
import com.renato.biblioteca.repositories.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	ApostaRepository apostaRepository;
	@Autowired
	ApostadorService apostadorService;
	
	public Aposta gerarAposta(String email){
		/*Date dataEHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataEHoraAtual);
		String hora = new SimpleDateFormat("HH:mm").format(dataEHoraAtual);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");*/
		
		Aposta aposta = null;
		aposta = new Aposta(null, System.currentTimeMillis(), apostadorService.buscar(email));
		aposta.setNumeros(gerarNumerosAleatorios(8, aposta));	
		return apostaRepository.save(aposta);
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
