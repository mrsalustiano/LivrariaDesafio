drop database livros;
create database livros;
use livros;

create table genero 
( 
	idgenero int  not null  AUTO_INCREMENT,
	descricao varchar(100) not null,
    primary key (idgenero)
);

create table livro 
(
	idlivro int  not null  AUTO_INCREMENT,
	titulo varchar(100) not null,
	preco decimal (10,2) ,
	estoque int,
	idgenero int  not null,
    primary key (idlivro),
    CONSTRAINT FK_Genero FOREIGN KEY (idgenero) References genero(idgenero)    
);

create table autor 
(
	idautor int  not null  AUTO_INCREMENT,
    nome varchar(100) not null,
    email varchar(100),
    primary key (idautor)
);
create table escreve 
(
	idlivro int  not null,
    idautor int  not null,
    primary key (idlivro, idautor),
    CONSTRAINT FK_Livros FOREIGN KEY (idlivro) References livro(idlivro),
    CONSTRAINT FK_Autor FOREIGN KEY (idautor) REFERENCES autor(idautor)
);

create table cliente 
(
	idcliente int  not null  AUTO_INCREMENT,
    nome varchar(100) not null,
    telefone varchar(45),
    primary key(idcliente)
);


create table venda
(
	idvenda int  not null  AUTO_INCREMENT,
    data date,
    total decimal (10,2),
    idcliente int  not null,
    primary key (idvenda),
    CONSTRAINT FK_Cliente FOREIGN KEY (idcliente) References cliente(idcliente)
);   

create table itens_de_venda 
(
	iditemvenda int not null auto_increment,
    idvenda int not null,
    idlivro int  not null,
    qtd int ,
    subtotal decimal (10,2),
    primary key (iditemvenda, idvenda, idlivro),
    CONSTRAINT FK_Venda FOREIGN KEY (idvenda) References venda(idvenda),
    CONSTRAINT FK_LivrosVenda FOREIGN KEY (idlivro) References livro(idlivro)
    
		
);

 



