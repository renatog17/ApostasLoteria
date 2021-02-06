package com.renato.biblioteca.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.renato.biblioteca.domain.Aposta;
import com.renato.biblioteca.domain.Numero;

public class ApostaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private List<Numero> numeros = new ArrayList<>();
	
	public ApostaDTO() {
		super();
	}

	public ApostaDTO(Aposta aposta) {
		this.id = aposta.getId();
		this.numeros = aposta.getNumeros();
		this.data = new Date(aposta.getData());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}	
}
