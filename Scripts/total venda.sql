select  cli.nome, v.data, max(total) TotalVenda
from venda v 
join cliente cli on v.idcliente = cli.idcliente
group by  cli.nome, v.data
order by max(total) desc
