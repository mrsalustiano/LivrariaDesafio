package com.qintess.Livraria.Controller;

import java.util.List;

import com.qintess.Livraria.Controller.DAO.ClienteDAO;
import com.qintess.Livraria.modelo.Cliente;


public class ListaCliente {

	public void listarCliente() {

		ClienteDAO dao = new ClienteDAO();
		List<Cliente> itens = dao.getLista();
		
		System.out.println("Nome\tIdCliente\tTelefone");

		for (Cliente cliente  : itens) {
			System.out.print(cliente.getNome() + "\t");
			System.out.print(cliente.getIdcliente() + "\t\t");
			System.out.println(cliente.getTelefone());

		}

		
	}
	
}
