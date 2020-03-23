package com.qintess.Livraria.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.qintess.Livraria.jdbc.ConnectionFactory;

public class ApagarItensDeVenda {
	
	
	public boolean apagar(int id) {
		String sql = "DELETE FROM itens_de_venda WHERE iditemvenda  = ?";

		try {
			 Connection connection = new ConnectionFactory().getConnection();
			 PreparedStatement pstm = connection.prepareStatement(sql);
			 pstm.setInt(1, id);
			 pstm.executeUpdate();
			 return true;
		} catch (Exception e) {
			return false;

		}
		
	}

}
