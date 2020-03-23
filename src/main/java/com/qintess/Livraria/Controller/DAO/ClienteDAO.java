package com.qintess.Livraria.Controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	Cliente cliente = new Cliente();

	public List<Cliente> getLista() {

		String sql = "SELECT idcliente, nome, telefone FROM cliente";
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setIdcliente(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
