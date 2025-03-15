Create TABLE PRODUTO(
	id UUID NOT NULL primary key,
	nome varchar(255) NOT NULL,
	descricao varchar(255) NOT NULL,
	categoria varchar(55) NOT NULL,
	imagem text NOT NULL,
	imagem2 text NOT NULL,
	imagem3 text,
	valor decimal NOT NULL,
	promocao boolean NOT NULL,
	valor_promocao decimal NOT NULL,
	quantidade integer NOT NULL,
	tamanhos text[] NOT NULL,
	quantidade_estoque integer NOT NULL

)


CREATE TABLE CUPOM(
	id UUID primary key NOT NULL,
	nome varchar(55) NOT NULL,
	valor double NOT NULL,
	valido boolean NOT NULL	
)




CREATE TABLE CARRINHO(	
	id UUID NOT NULL primary key,
	nome varchar(255) NOT NULL,
	cupom_id UUID,
	total decimal,
	
	FOREIGN KEY (cupom_id) REFERENCES cupom(id)
)





CREATE TABLE CARRINHO_PRODUTOS(
	produto_id UUID ,
	carrinho_id UUID ,
	
	PRIMARY KEY(produto_id,carrinho_id),
	FOREIGN KEY(produto_id) REFERENCES produto(id),
	FOREIGN KEY(carrinho_id) REFERENCES carrinho(id)
	
)

CREATE TABLE USUARIO(
	id UUID primary key NOT NULL,
	nome varchar(55) NOT NULL,
	login_user varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
	role varchar(55) NOT NULL,
	email varchar(255) NOT NULL
	
	
	
)












