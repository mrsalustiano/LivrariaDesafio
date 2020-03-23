package com.qintess.Livraria.Controller;

import java.util.List;

import com.qintess.Livraria.Controller.DAO.ItensDeVendaDAO;
import com.qintess.Livraria.modelo.ItensPesquisado;

public class ListaItensDeVenda {
	
	public void listar() {
		ItensDeVendaDAO dao = new ItensDeVendaDAO();

		List<ItensPesquisado> itens = dao.getLista();
		System.out.println("Nome\tTitulo\tData\t\tQtd\tSubtotal\tTotal\t\tIDVenda\tIdLivro\tIdCliente\tIDItemVenda");

		for (ItensPesquisado itempesquisado : itens) {
			System.out.print(itempesquisado.getNome() + "\t");
			System.out.print(itempesquisado.getTitulo() + "\t");
			System.out.print(itempesquisado.getData() + "\t");
			System.out.print(itempesquisado.getQtd() + "\t");
			System.out.print(itempesquisado.getSubtotal() + "\t\t");
			System.out.print(itempesquisado.getTotal() + "\t\t");
			System.out.print(itempesquisado.getIdvenda() + "\t");
			System.out.print(itempesquisado.getIdlivro() + "\t");
			System.out.print(itempesquisado.getIdcliente() + "\t\t");
			System.out.println(itempesquisado.getIditemvenda());

		}

	}


}
