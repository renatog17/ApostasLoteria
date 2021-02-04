package com.renato.biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.domain.Numero;
import com.renato.biblioteca.repositories.ApostaRepository;
import com.renato.biblioteca.repositories.ApostadorRepository;
import com.renato.biblioteca.repositories.NumeroRepository;

@SpringBootApplication
public class ApostaLoteriaApplication implements CommandLineRunner{

	@Autowired
	private ApostadorRepository apostadorRepository;
	@Autowired
	private ApostaRepository apostaRepository;
	@Autowired
	private NumeroRepository numeroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApostaLoteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Apostador ap1 = new Apostador("123@123.123", "Renato Gomes de Oliveira", "123", "123");
		Apostador ap2 = new Apostador("456@456.456", "Fulano Alecrim da Silva", "456", "456");
		Apostador ap3 = new Apostador("789@789.789", "Elisabeth Rainha Da Inglaterra", "789", "789");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Aposta a1 = new Aposta(null, sdf.parse("17/08/1998 17:59"), ap1);
		Aposta a2 = new Aposta(null, sdf.parse("17/08/1998 18:03"), ap1);
		Aposta a3 = new Aposta(null, sdf.parse("27/04/1999 17:59"), ap2);
		Aposta a4 = new Aposta(null, sdf.parse("14/08/1998 20:55"), ap3);
		
		Numero n1 = new Numero(null, 3, a1);
		Numero n2 = new Numero(null, 5, a1);
		Numero n3 = new Numero(null, 7, a1);
		
		ap1.getApostas().addAll(Arrays.asList(a1,a2));
		ap2.getApostas().addAll(Arrays.asList(a3));
		ap3.getApostas().addAll(Arrays.asList(a4));
		
		a1.getNumeros().addAll(Arrays.asList(n1,n2,n3));
		
		apostadorRepository.saveAll(Arrays.asList(ap1,ap2,ap3));
		apostaRepository.saveAll(Arrays.asList(a1, a2,a3,a4));
		numeroRepository.saveAll(Arrays.asList(n1,n2,n3));
	}
}
