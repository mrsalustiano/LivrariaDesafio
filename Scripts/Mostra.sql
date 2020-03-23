
select vd.data , cd.nome, lv.titulo, iv.qtd, iv.subtotal ,  vd.total,   iv.idvenda, iv.idlivro,vd.idcliente, iv.iditemvenda
from itens_de_venda iv
inner join livro  lv on lv.idlivro = iv.idlivro 
inner join venda vd on iv.idvenda = vd.idvenda
inner join cliente cd on cd.idcliente = vd.idcliente
group by iv.idvenda, iv.idlivro, iv.qtd, iv.subtotal, cd.nome
order by cd.nome, lv.titulo
 