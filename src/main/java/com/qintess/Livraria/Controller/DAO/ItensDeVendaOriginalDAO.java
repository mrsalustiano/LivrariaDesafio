package com.qintess.Livraria.Controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.ItensDeVenda;

public class ItensDeVendaOriginalDAO {
	private Connection  connection;
	
	public ItensDeVendaOriginalDAO( ) {
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	ItensDeVenda venda  = new ItensDeVenda();
	
	public List<ItensDeVenda> getLista() {
		try { 
			
			List<ItensDeVenda> vendas = new ArrayList<ItensDeVenda>();
			String sql = "SELECT iditemvenda, idvenda, idlivro, qtd, subtotal FROM itens_de_venda;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			
			while (rs.next()) {
				ItensDeVenda  venda =  new  ItensDeVenda();
				venda.setIditemvenda(rs.getInt("iditemvenda"));
				venda.setIdvenda(rs.getInt("idvenda"));
				venda.setIdlivro(rs.getInt("idlivro"));
				venda.setQtd(rs.getInt("qtd"));
				venda.setSubtotal(rs.getDouble("subtotal"));
				 
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
