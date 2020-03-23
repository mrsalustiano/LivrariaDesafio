package com.qintess.Livraria.Relatorios.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.MaiorQuantidadeDeCompras;

public class MaiorQuantidadeDeComprasRelatorioDAO {
	private Connection connection;

	public MaiorQuantidadeDeComprasRelatorioDAO() {

		this.connection = new ConnectionFactory().getConnection();

	}

	MaiorQuantidadeDeCompras maiorQuantidadeDeCompras = new MaiorQuantidadeDeCompras();

	public List<MaiorQuantidadeDeCompras> getLista() {

		try {
			List<MaiorQuantidadeDeCompras> compras = new ArrayList<MaiorQuantidadeDeCompras>();
			String sql = "SELECT count(v.idcliente) as quantidade, c.nome as nome\r\n" + "FROM venda v\r\n"
					+ "JOIN  cliente c  ON v.idcliente = c.idcliente\r\n" + "GROUP BY v.idcliente, c.nome\r\n"
					+ "ORDER BY count(v.idcliente) desc,c.nome";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MaiorQuantidadeDeCompras compra = new MaiorQuantidadeDeCompras();
				compra.setClienteNome(rs.getString("nome"));
				compra.setQuantidade(rs.getInt("quantidade"));
				compras.add(compra);

			}
			rs.close();
			stmt.close();
			return compras;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
