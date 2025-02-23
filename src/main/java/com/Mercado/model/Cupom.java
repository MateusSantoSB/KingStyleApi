package com.Mercado.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cupom {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="valido")
	private boolean valido;
	
	
	public Cupom(){
		
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public boolean isValido() {
		return valido;
	}


	public void setValido(boolean valido) {
		this.valido = valido;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nome, valido, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupom other = (Cupom) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && valido == other.valido
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
	
	
	
}
