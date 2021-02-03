package com.renato.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Numero {
	
	@Id
	private Integer numero;
	
	@ManyToMany
	@JoinTable(name = "APOSTA_NUMERO",
		joinColumns = @JoinColumn(name = "numero_id"), 
		inverseJoinColumns = @JoinColumn(name = "aposta_id")
	)
	private List<Aposta> apostas = new ArrayList<>();
	
	public Numero() {
		
	}
	
	public Numero(Integer numero) {
		super();
		this.setNumero(numero);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
	
}
