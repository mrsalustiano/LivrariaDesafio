use livros;

SELECT sum(g.qtd) as soma, l.titulo
FROM itens_de_venda g
JOIN livro l ON l.idlivro = g.idlivro
GROUP BY l.titulo 
ORDER BY sum(g.qtd) desc,l.titulo;








