package com.qintess.Livraria.Controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.Livro;

public class LivroDAO {
	private Connection connection;

	public LivroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	Livro livro = new Livro();
	
	public List<Livro> getLista() {

		String sql = "SELECT idlivro, titulo, preco, estoque, idgenero FROM livro";
		try {
			List<Livro> livros = new ArrayList<Livro>();

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro();

				livro.setIdlivro(rs.getInt("idlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setPreco(rs.getDouble("preco"));
				livro.setEstoque(rs.getInt("estoque"));
				livro.setIdgenero(rs.getInt("idgenero"));
				
				livros.add(livro);
			}
			rs.close();
			stmt.close();
			return livros;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
