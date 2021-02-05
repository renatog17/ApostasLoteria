package com.renato.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.services.ApostaService;
import com.renato.biblioteca.services.ApostadorService;

@RequestMapping(value = "/aposta")
@RestController
public class ApostaResource {

	//@Autowired
	//private ApostadorService apostadorService;
	@Autowired
	private ApostaService apostaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> gerarAposta(@RequestBody Apostador apostador){
		//Apostador apostadorBusca = apostadorService.buscar(apostador.getEmail());
		Aposta aposta = apostaService.gerarAposta(apostador.getEmail());
		return ResponseEntity.ok().body(aposta);
	}
}
