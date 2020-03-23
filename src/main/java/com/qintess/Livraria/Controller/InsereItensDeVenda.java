package com.qintess.Livraria.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qintess.Livraria.jdbc.ConnectionFactory;

public class InsereItensDeVenda {
	
	public InsereItensDeVenda() {
		
	}
	
	public void insereItem(int idvenda, int idlivro, double subtotal, int quantidade) {

		String sql = "INSERT INTO itens_de_venda ( idvenda , idlivro , qtd , subtotal ) VALUES \r\n"
				+ "(? , ? , ? , ? ) ";
		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idvenda);
			stmt.setInt(2, idlivro);
			stmt.setInt(3, quantidade);			
			stmt.setDouble(4, subtotal);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		
	}

}
