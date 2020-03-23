package com.qintess.Livraria.Controller;

import java.util.List;

import com.qintess.Livraria.Controller.DAO.LivroDAO;
import com.qintess.Livraria.modelo.Livro;

public class ListaLivros {

	public void listarLivros() {

		LivroDAO dao = new LivroDAO();
		List<Livro> itens = dao.getLista();
		
		System.out.println("idlivro\ttitulo\tpreco\testoque\tidgenero");
		for (Livro livro  : itens) {
			System.out.print(livro.getIdlivro() + "\t");
			System.out.print(livro.getTitulo() + "\t");
			System.out.print(livro.getPreco() + "\t");
			System.out.print(livro.getEstoque() + "\t");
			System.out.println(livro.getIdgenero() + "\t");
			
			
		}

		
	}
}