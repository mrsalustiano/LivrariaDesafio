package com.qintess.Livraria.Controller;

import java.util.List;

import com.qintess.Livraria.Controller.DAO.VendaDAO;
import com.qintess.Livraria.modelo.Venda;

public class ListaVendas {

	public void listarVendas() {
		
		VendaDAO dao = new VendaDAO();
		
		List<Venda> itens = dao.getLista();
		
		System.out.println("data\tidcliente\tidvenda\ttotal");

		for (Venda venda  : itens) {
			System.out.print(venda.getData() + "\t");
			System.out.print(venda.getIdcliente() + "\t");
			System.out.print(venda.getIdvenda() + "\t");
			System.out.println(venda.getTotal());

		}
		
	}
}
