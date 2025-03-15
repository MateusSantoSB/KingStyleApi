package com.Mercado.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Mercado.dto.ProdutoDTO;
import com.Mercado.dto.ProdutoPromocaoDTO;
import com.Mercado.dto.ProdutoSaveDTO;
import com.Mercado.mapper.ProdutoMapper;
import com.Mercado.model.Produto;
import com.Mercado.service.ProdutoService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	private final ProdutoService service;
	private final ProdutoMapper mapper;
	
	public ProdutoController(ProdutoService service,ProdutoMapper mapper) {
		this.service=service;
		this.mapper=mapper;
	}
	
	
	@PostMapping
	public ResponseEntity<Void> salvarProduto(@RequestBody @Valid ProdutoSaveDTO dto){
		Produto produto=mapper.toEntity(dto);
		service.salvarProduto(produto);
		
		URI loc=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/"+produto.getId())
				.build()
				.toUri();
		
		return ResponseEntity.created(loc).build();
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable UUID id){
		Optional<Produto> busca=service.buscarProduto(id);
		
		if(busca==null) {
			return null;
		}
		
		
		Produto produto=busca.get();
		ProdutoDTO dto=mapper.toDTO(produto);
		
		
		return ResponseEntity.ok(dto);
		

	}
	
	@PutMapping("/att/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable UUID id , @RequestBody ProdutoSaveDTO dto){
		Produto produto=mapper.toEntity(dto);
		this.service.atualizarproduto(id,produto);
		
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/del/{id}")
		public ResponseEntity<Void> deletarProduto(@PathVariable UUID id){
			this.service.removerProduto(id);
			return ResponseEntity.ok().build();
	}

	
	
	@GetMapping("/promocao")
	public ResponseEntity<org.springframework.data.domain.Page<ProdutoPromocaoDTO>>listaProdutosASC(@RequestParam int pagina,@RequestParam int tamanho){
		
		org.springframework.data.domain.Page<Produto> page=service.listaProdutoPaginadaPromocao(pagina, tamanho);
			
		org.springframework.data.domain.Page<ProdutoPromocaoDTO> dto=page.map(mapper::toPromocaoDTO);
		
		return ResponseEntity.ok(dto);
	}

	
	
	
	
	@GetMapping("/home")
	public ResponseEntity<org.springframework.data.domain.Page<ProdutoDTO>> listaProdutoPaginada(@RequestParam int pagina,@RequestParam int tamanho){
		
		org.springframework.data.domain.Page<Produto> page=service.listaProdutoPaginada(pagina,tamanho);
		org.springframework.data.domain.Page<ProdutoDTO> dto=page.map(mapper::toDTO);
		
		return ResponseEntity.ok(dto);
	}
	
	
	
	
	
	
	@GetMapping("/search/")
	public ResponseEntity<org.springframework.data.domain.Page<ProdutoDTO>> buscarProduto(@RequestParam String nome,@RequestParam int pagina,@RequestParam int tamanho){
		
		org.springframework.data.domain.Page<Produto> produto=service.buscarProdutoPaginadaPorNome(nome,pagina,tamanho);
		
		Page<ProdutoDTO> dto=produto.map(mapper::toDTO);
		
		
		
		
		return ResponseEntity.ok(dto);	
	}
	
	
	
	
	
	
	
}
