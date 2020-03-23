use livros;

SELECT count(v.idcliente) as quantidade, c.nome as nome
FROM venda v
JOIN  cliente c  ON v.idcliente = c.idcliente
GROUP BY v.idcliente, c.nome
ORDER BY count(v.idcliente) desc,c.nome;
