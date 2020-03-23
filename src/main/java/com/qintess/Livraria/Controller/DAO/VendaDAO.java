package com.qintess.Livraria.Controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.Venda;

public class VendaDAO {
	private Connection connection;
	
	public VendaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	Venda venda = new Venda();
	
	
	public List<Venda> getLista() {
		
		String sql = "SELECT idvenda, data, total, idcliente FROM venda";
		try {
			List<Venda> vendas = new ArrayList<Venda>();

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Venda venda = new Venda();
				venda.setIdcliente(rs.getInt("idcliente"));
				venda.setIdvenda(rs.getInt("idvenda"));
				venda.setTotal(rs.getDouble("total"));
				venda.setData(rs.getDate("data"));
				
				vendas.add(venda);
				
			}
			rs.close();
			stmt.close();
			return vendas;
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
