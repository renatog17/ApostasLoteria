package com.renato.biblioteca.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostaDTO;
import com.renato.biblioteca.services.ApostaService;

@RequestMapping(value = "/aposta")
@RestController
public class ApostaResource {

	//@Autowired
	//private ApostadorService apostadorService;
	@Autowired
	private ApostaService apostaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApostaDTO> gerarAposta(@RequestBody Apostador apostador){
		Aposta aposta = apostaService.gerarAposta(apostador.getEmail());
		ApostaDTO apostaDTO = new ApostaDTO(aposta);
		return ResponseEntity.ok().body(apostaDTO);
	}
	
	@RequestMapping(value = "/{email}")
	public ResponseEntity<List<ApostaDTO>> listarApostasPorEmail(@PathVariable String email){
		List<Aposta> apostas = apostaService.buscarApostasPorEmail(email);
		List<ApostaDTO> apostasDTO = apostas.stream().map(obj -> new ApostaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDTO);
	}
	
}
