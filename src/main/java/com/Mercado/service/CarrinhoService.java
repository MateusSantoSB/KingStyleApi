package com.Mercado.service;

import org.springframework.stereotype.Service;

import com.Mercado.model.Carrinho;
import com.Mercado.model.Produto;
import com.Mercado.model.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	private final CarrinhoRepository repository;
	
	public CarrinhoService(CarrinhoRepository repository) {
		this.repository=repository;
	}
	
	
	public void salvar(Carrinho carrinho) {
		repository.save(carrinho);
	}
	
	
	
	public Carrinho finalizarCarrinho(Carrinho carrinho) {
		double total=0;
	
		if(carrinho.getProdutos()!=null) {   
			
			if( carrinho.getCupom()!=null && carrinho.getCupom().isValido()==true) {
				
			
					
				
				for(Produto produto:carrinho.getProdutos()) {
					
					if(produto.getPromocao()==true) {
						produto.setValor( produto.getValor()-(produto.getValor()/100*produto.getValorPromocao()));
						produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-produto.getQuantidade());
						total+=produto.getValor()*produto.getQuantidade();
						
					}else {
						produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-produto.getQuantidade());
						total+=produto.getValor()*produto.getQuantidade();
					}
				}
				carrinho.setTotal(total-(total/100*carrinho.getCupom().getValor()));
				
				this.salvar(carrinho);
				return carrinho;
				
				
				
			}else{
				for(Produto produto:carrinho.getProdutos()) {
					
					if(produto.getPromocao()==true) {
						produto.setValor( produto.getValor()-(produto.getValor()/100*produto.getValorPromocao()));
						produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-produto.getQuantidade());
						total+=produto.getValor()*produto.getQuantidade();
						
					}else {
						produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-produto.getQuantidade());
						total+=produto.getValor()*produto.getQuantidade();
						
					}
				}
				carrinho.setTotal(total);
				this.salvar(carrinho);
				return carrinho;
			}
		}else {
			return null;
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
