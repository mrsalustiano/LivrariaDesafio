package com.qintess.Livraria.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.qintess.Livraria.jdbc.ConnectionFactory;

public class AtualizarItensDeVenda {

	public boolean AtualizarLivro(int livro, int idItemVenda) {

		String sql = "UPDATE  itens_de_venda SET idlivro  = ? WHERE iditemvenda  = ? ";
		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, livro);
			stmt.setInt(2, idItemVenda);
			stmt.execute();
			stmt.close();
			
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean AtualizarQuantidade(int quantidade ,  int idItemVenda) {
		String sql = "UPDATE  itens_de_venda SET qtd  = ? WHERE iditemvenda  = ? ";

		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, quantidade);
			stmt.setInt(2, idItemVenda);
			stmt.execute();
			stmt.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean AtualizarSubtotal(double subtotal, int idItemVenda) {
		String sql = "UPDATE  itens_de_venda SET  subtotal  = ? WHERE iditemvenda  = ?";
		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, subtotal);
			stmt.setInt(2, idItemVenda);
			stmt.execute();
			stmt.close();

			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
