package com.Mercado.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carrinho")
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToMany
	@JoinTable(
			name="carrinho_produtos",
			joinColumns = @JoinColumn(name = "carrinho_id"),
	        inverseJoinColumns = @JoinColumn(name = "produto_id") 
	)
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name="cupom_id")
	private Cupom cupom;
	
	@Column(name="total")
	private double total;

	
	public Carrinho() {
		
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cupom, id, nome, produtos, total);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		return Objects.equals(cupom, other.cupom) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(produtos, other.produtos)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}



	
	
	
	
	
}
