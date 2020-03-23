
use livros;

/*
data
mysql> insert into CurDateDemo values(curdate());

*/


INSERT INTO genero ( descricao ) VALUES ("Ciência da Computação");
INSERT INTO genero ( descricao ) VALUES ("Java");
INSERT INTO genero ( descricao ) VALUES ("Aventura");
INSERT INTO genero ( descricao ) VALUES ("Terror");

INSERT INTO autor ( nome , email ) VALUES ("Robin Cook" , "robin@cook.com");
INSERT INTO autor ( nome , email ) VALUES ("Loiane" , "loiane@java.com");
INSERT INTO autor ( nome , email ) VALUES ("Walt Disney" , "walt@disney.com");
INSERT INTO autor ( nome , email ) VALUES ("Stephen King" , "king@king.com");
INSERT INTO autor ( nome , email ) VALUES ("JJ " , "JJking.com");
INSERT INTO autor ( nome , email ) VALUES ("KK" , "KK@king.com");


INSERT INTO cliente ( nome,telefone) VALUES ("Marcelo", "11 98852-8927");
INSERT INTO cliente ( nome,telefone) VALUES ("Victor", "11 99999-9999");
INSERT INTO cliente ( nome,telefone) VALUES ("Eduardo", "13 99999-9999");
INSERT INTO cliente ( nome,telefone) VALUES ("Guilherme", "11 00000-0000");

INSERT INTO livro ( titulo , preco , estoque , idgenero ) VALUES ( "IT" , 100.0 , 100 , (select idgenero from genero where descricao = 'Terror') );
INSERT INTO livro ( titulo , preco , estoque , idgenero ) VALUES ( "Java Biblia" , 400.0 , 10 , (select idgenero from genero where descricao = 'Java') );
INSERT INTO livro ( titulo , preco , estoque , idgenero ) VALUES ( "Harry Potter Completo " , 300.0 , 10 , (select idgenero from genero where descricao = 'Aventura') );
INSERT INTO livro ( titulo , preco , estoque , idgenero ) VALUES ( "C++" , 200.0 , 20 , (select idgenero from genero where descricao like 'Ciência%') );

 
INSERT INTO escreve (idlivro, idautor) values ( (select idlivro from livro where titulo = "IT"), (select idautor from autor where  nome like "%king"));
INSERT INTO escreve (idlivro, idautor) values ( (select idlivro from livro where titulo = "IT"), (select idautor from autor where  nome like "%cook"));

INSERT INTO escreve (idlivro, idautor) values ( (select idlivro from livro where titulo = "C++"), (select idautor from autor where  nome like "%kk%"));
INSERT INTO escreve (idlivro, idautor) values ( (select idlivro from livro where titulo = "C++"), (select idautor from autor where  nome like "%jj%"));

INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 3000.0 , (select idcliente from cliente where nome like '%Victor%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
( (select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%vic%')), 
(select idlivro from livro where titulo like '%harry%'), 20, (select sum(20 * preco) from livro where titulo like '%harry%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 4000.0 , (select idcliente from cliente where nome like '%Edu%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
( (select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%edu%')), 
(select idlivro from livro where titulo like '%harry%'), 20, (select sum(20 * preco) from livro where titulo like '%harry%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 1000.0 , (select idcliente from cliente where nome like '%gui%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
( (select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%gui%')), 
(select idlivro from livro where titulo like '%harry%'), 20, (select sum(20 * preco) from livro where titulo like '%harry%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 5000.0 , (select idcliente from cliente where nome like '%Marcelo%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
( (select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%mar%')), 
(select idlivro from livro where titulo like '%harry%'), 20, (select sum(20 * preco) from livro where titulo like '%harry%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 7000.0 , (select idcliente from cliente where nome like '%Marcelo%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
((select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%mar%')), 
(select idlivro from livro where titulo like '%it%'), 30, (select sum(30 * preco) from livro where titulo like '%it%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 7000.0 , (select idcliente from cliente where nome like '%Marcelo%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
((select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%mar%')), 
(select idlivro from livro where titulo like '%jav%'), 30, (select sum(30 * preco) from livro where titulo like '%jav%'));


INSERT INTO venda ( data, total , idcliente ) VALUES ( curdate(), 7000.0 , (select idcliente from cliente where nome like '%Marcelo%'));
INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES 
((select max(idvenda) from venda where idcliente = (select max(idcliente) from cliente where nome like '%mar%')), 
(select idlivro from livro where titulo like '%c++%'), 30, (select sum(30 * preco) from livro where titulo like '%c++%'));





