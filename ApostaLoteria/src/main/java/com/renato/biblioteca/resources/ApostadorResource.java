package com.renato.biblioteca.resources;

import java.io.ObjectOutputStream.PutField;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostadorDTO;
import com.renato.biblioteca.dto.ApostadorNewDTO;
import com.renato.biblioteca.services.ApostadorService;

@RestController
@RequestMapping(value = "/apostadores")
public class ApostadorResource {

	@Autowired
	private ApostadorService apostadorService;
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<Apostador> buscar(@PathVariable String email){
		Apostador apostador = apostadorService.findByEmail(email);
		return ResponseEntity.ok().body(apostador);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarApostador(@Valid @RequestBody ApostadorNewDTO apostadorNewDto){
		Apostador apostador = apostadorService.fromDto(apostadorNewDto);
		apostadorService.salvar(apostador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
				.buildAndExpand(apostador.getEmail()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ApostadorDTO apostadorDto, @PathVariable String email){
		Apostador apostador = apostadorService.fromDto(apostadorDto);
		//apostador.setEmail(email);
		apostadorService.update(apostador, email);
		return ResponseEntity.noContent().build();
	}
}
