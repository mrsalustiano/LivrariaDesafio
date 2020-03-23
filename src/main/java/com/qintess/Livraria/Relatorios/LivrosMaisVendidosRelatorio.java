package com.qintess.Livraria.Relatorios;

import java.util.List;

import com.qintess.Livraria.Relatorios.DAO.LivrosMaisVendidosRelatorioDAO;
import com.qintess.Livraria.modelo.LivrosMaisVendidos;

public class LivrosMaisVendidosRelatorio {
	
	public void mostrar() {
		
		LivrosMaisVendidosRelatorioDAO dao = new LivrosMaisVendidosRelatorioDAO();
		
		List<LivrosMaisVendidos> itens = dao.getLista();
		System.out.println("---------------------------------");
		System.out.println("Relatorio de Livros Mais Vendidos");
		System.out.println("---------------------------------");

		for (LivrosMaisVendidos livros : itens) {
			System.out.println("Titulo     : " + livros.getTitulo() );
			System.out.println("Quantidade : " + livros.getSoma());
			System.out.println("---------------------------------");

		}

		
	}

}
