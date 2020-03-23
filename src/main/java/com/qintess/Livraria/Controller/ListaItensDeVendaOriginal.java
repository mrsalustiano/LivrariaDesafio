package com.qintess.Livraria.Controller;

import java.util.List;

import com.qintess.Livraria.Controller.DAO.ItensDeVendaOriginalDAO;
import com.qintess.Livraria.modelo.ItensDeVenda;


public class ListaItensDeVendaOriginal {
	
	public void listar() {
		ItensDeVendaOriginalDAO dao = new ItensDeVendaOriginalDAO();

		List<ItensDeVenda> itens = dao.getLista();
		System.out.println("idItemDeVenda\tIdlivro\tIdVenda\tQTD\tSubtotal");

		for (ItensDeVenda item : itens) {
			System.out.print(item.getIditemvenda() + "\t\t");
			System.out.print(item.getIdlivro() + "\t");
			System.out.print(item.getIdvenda() + "\t");
			System.out.print(item.getQtd() + "\t");
			System.out.print(item.getSubtotal() + "\n");

		}

	}


}
