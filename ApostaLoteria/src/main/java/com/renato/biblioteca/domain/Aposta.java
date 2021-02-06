package com.renato.biblioteca.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aposta implements Serializable, Comparable<Aposta>{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long data;
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="apostador_id")
	private Apostador apostador;
	//@JsonManagedReference
	@OneToMany(mappedBy = "aposta")
	private List<Numero> numeros = new ArrayList<>();
	
	public Aposta() {
		
	}

	public Aposta(Integer id, Long data, Apostador apostador) {
		super();
		this.id = id;
		this.data = data;
		this.apostador = apostador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Apostador getApostador() {
		return apostador;
	}

	public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}
	
	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Aposta anotherAposta) {
		if (this.data > anotherAposta.getData()) { 
			return -1; 
		} if (this.data > anotherAposta.getData()) { 
			return 1; 
		} 
		return 0;
	}
}
