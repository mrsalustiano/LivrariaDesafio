package com.qintess.Livraria.Relatorios.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.LivrosMaisVendidos;

public class LivrosMaisVendidosRelatorioDAO {

	private Connection connection;

	public LivrosMaisVendidosRelatorioDAO() {
		this.connection = new ConnectionFactory().getConnection();

	}

	LivrosMaisVendidos livrosMaisVendidos = new LivrosMaisVendidos();

	public List<LivrosMaisVendidos> getLista() {

		try {
			List<LivrosMaisVendidos> vendidos = new ArrayList<LivrosMaisVendidos>();
			String sql = "SELECT sum(g.qtd) as soma, l.titulo as titulo \r\n" + "FROM itens_de_venda g\r\n"
					+ "JOIN livro l ON l.idlivro = g.idlivro\r\n" + "GROUP BY l.titulo \r\n"
					+ "ORDER BY sum(g.qtd) desc,l.titulo";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LivrosMaisVendidos vendas = new LivrosMaisVendidos();
				vendas.setSoma(rs.getInt("soma"));
				vendas.setTitulo(rs.getString("titulo"));
				vendidos.add(vendas);

			}
			rs.close();
			stmt.close();
			return vendidos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
