package com.renato.biblioteca.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.services.validation.ApostadorInsert;

@ApostadorInsert
public class ApostadorNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	@NotEmpty
	@Length(min = 11, max = 11, message = "O tamanho do telefone precisa ter 11 caracteres")
	private String telefone;
	@NotEmpty
	@Length(min = 11, max = 11, message = "O tamanho do cpf precisa ter 11 caracteres")
	private String cpf;
	
	public ApostadorNewDTO() {
		super();
	}

	public ApostadorNewDTO(Apostador apostador) {
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
