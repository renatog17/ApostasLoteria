package com.renato.biblioteca.dto;

import java.io.Serializable;

import com.renato.biblioteca.domain.Apostador;

public class ApostadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	private String telefone;
	private String cpf;
	
	public ApostadorDTO() {
		super();
	}

	public ApostadorDTO(Apostador apostador) {
		super();
		this.email = apostador.getEmail();
		this.nome = apostador.getNome();
		this.telefone = apostador.getTelefone();
		this.cpf = apostador.getCpf();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
}
