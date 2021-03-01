package com.renato.biblioteca.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.renato.biblioteca.domain.Apostador;

public class ApostadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	@NotEmpty
	@Length(min = 11, max = 11, message = "O tamanho do telefone precisa ter 11 caracteres")
	private String telefone;
	
	public ApostadorDTO() {
		super();
	}

	public ApostadorDTO(Apostador apostador) {
		super();
		this.nome = apostador.getNome();
		this.telefone = apostador.getTelefone();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
