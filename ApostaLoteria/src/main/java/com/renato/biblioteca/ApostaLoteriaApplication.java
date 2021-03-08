package com.renato.biblioteca;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.repositories.ApostadorRepository;

@SpringBootApplication
public class ApostaLoteriaApplication implements CommandLineRunner{

	@Autowired
	private ApostadorRepository apostadorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApostaLoteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws ParseException{
		Apostador ap1 = new Apostador(null, "123@123.123", "Renato Gomes de Oliveira", "123", "123");
		Apostador ap2 = new Apostador(null, "456@456.456", "Fulano Alecrim da Silva", "456", "456");
		Apostador ap3 = new Apostador(null, "789@789.789", "Elisabeth Rainha Da Inglaterra", "789", "789");
		apostadorRepository.saveAll(Arrays.asList(ap1,ap2,ap3));
	}
}
