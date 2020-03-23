package com.qintess.Livraria.Relatorios;

import java.util.List;

import com.qintess.Livraria.Relatorios.DAO.MaiorQuantidadeDeComprasRelatorioDAO;
import com.qintess.Livraria.modelo.MaiorQuantidadeDeCompras;

public class MaiorQuantidadeDeComprasRelatorio {
	
	public void Mostrar() {
		
		MaiorQuantidadeDeComprasRelatorioDAO dao = new MaiorQuantidadeDeComprasRelatorioDAO();
		
		List<MaiorQuantidadeDeCompras>itens = dao.getLista();
		
		System.out.println("--------------------------------------");
		System.out.println("Relatorio de Clientes com Mais Pedidos");
		System.out.println("--------------------------------------");

		for (MaiorQuantidadeDeCompras pedidos : itens) {
			System.out.println("Nome       : " + pedidos.getClienteNome());
			System.out.println("Quantidade : " + pedidos.getQuantidade());
			System.out.println("---------------------------------");

		}

	}

}
