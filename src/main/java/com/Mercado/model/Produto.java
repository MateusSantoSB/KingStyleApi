package com.Mercado.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="imagem")
	private String imagem;
	
	@Column(name="imagem2")
	private String imagem2;
	
	@Column(name="imagem3")
	private String imagem3;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="promocao")
	private Boolean promocao;
	
	@Column(name="valor_promocao")
	private Double valorPromocao;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Column(name="quantidade_estoque")
	private int quantidadeEstoque;
	
	@Column(name="tamanhos")
	private List<String> tamanhos;
	
	
	@ManyToMany(mappedBy = "produtos")
	private List<Carrinho>carrinho;
	
	
	public Produto(){
		
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Boolean getPromocao() {
		return promocao;
	}


	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}


	public Double getValorPromocao() {
		return valorPromocao;
	}


	public void setValorPromocao(Double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	

	public List<String> getTamanhos() {
		return tamanhos;
	}


	public void setTamanhos(List<String> tamanhos) {
		this.tamanhos = tamanhos;
	}


	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public List<Carrinho> getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}


	public String getImagem2() {
		return imagem2;
	}


	public void setImagem2(String imagem2) {
		this.imagem2 = imagem2;
	}


	public String getImagem3() {
		return imagem3;
	}


	public void setImagem3(String imagem3) {
		this.imagem3 = imagem3;
	}


	@Override
	public int hashCode() {
		return Objects.hash(carrinho, categoria, descricao, id, imagem, imagem2, imagem3, nome, promocao, quantidade,
				quantidadeEstoque, tamanhos, valor, valorPromocao);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(carrinho, other.carrinho) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(imagem, other.imagem) && Objects.equals(imagem2, other.imagem2)
				&& Objects.equals(imagem3, other.imagem3) && Objects.equals(nome, other.nome)
				&& Objects.equals(promocao, other.promocao) && quantidade == other.quantidade
				&& quantidadeEstoque == other.quantidadeEstoque && Objects.equals(tamanhos, other.tamanhos)
				&& Objects.equals(valor, other.valor) && Objects.equals(valorPromocao, other.valorPromocao);
	}


	
	

	
	

	

	
	
	
	
	
}
