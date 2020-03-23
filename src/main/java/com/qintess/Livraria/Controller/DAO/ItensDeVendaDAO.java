package com.qintess.Livraria.Controller.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qintess.Livraria.jdbc.ConnectionFactory;
import com.qintess.Livraria.modelo.ItensPesquisado;

public class ItensDeVendaDAO {
	private Connection  connection;
	
	public ItensDeVendaDAO( ) {
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	ItensPesquisado pesq = new ItensPesquisado();
	
	public List<ItensPesquisado> getLista() {
		try { 
			
			List<ItensPesquisado> pesquisados = new ArrayList<ItensPesquisado>();
			String sql = "\r\n" + 
					"select vd.data , cd.nome, lv.titulo, iv.qtd, iv.subtotal ,  vd.total,   iv.idvenda, iv.idlivro,vd.idcliente, iv.iditemvenda\r\n" + 
					"from itens_de_venda iv\r\n" + 
					"inner join livro  lv on lv.idlivro = iv.idlivro \r\n" + 
					"inner join venda vd on iv.idvenda = vd.idvenda\r\n" + 
					"inner join cliente cd on cd.idcliente = vd.idcliente\r\n" + 
					"group by iv.idvenda, iv.idlivro, iv.qtd, iv.subtotal, cd.nome\r\n" + 
					"order by cd.nome, lv.titulo";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			
			while (rs.next()) {
				ItensPesquisado pesquisado =  new  ItensPesquisado();
				
				pesquisado.setData(rs.getString("vd.data"));
				
				pesquisado.setIdcliente( rs.getInt("vd.idcliente"));
				pesquisado.setIdlivro(rs.getInt("iv.idlivro"));
				pesquisado.setIdvenda(rs.getInt("iv.idvenda"));
				
				pesquisado.setNome(rs.getString("cd.nome"));
				pesquisado.setQtd(rs.getInt("iv.qtd"));
				pesquisado.setSubtotal(rs.getDouble("iv.subtotal"));
				
				pesquisado.setTitulo(rs.getString("lv.titulo"));
				pesquisado.setTotal(rs.getDouble("vd.total"));
				pesquisado.setIditemvenda(rs.getInt("iv.iditemvenda"));
				 
				pesquisados.add(pesquisado);
								
			}
			rs.close();
			stmt.close();
			return pesquisados;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}  

}
