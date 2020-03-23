package com.qintess.Livraria.modelo;

public class ItensDeVenda {
	
	public int getIditemvenda() {
		return iditemvenda;
	}
	public void setIditemvenda(int iditemvenda) {
		this.iditemvenda = iditemvenda;
	}
	private int iditemvenda;
	private int idvenda;
	private int idlivro;
	private int qtd;
    private double subtotal;
    
    
	public int getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}
	public int getIdlivro() {
		return idlivro;
	}
	public void setIdlivro(int idlivro) {
		this.idlivro = idlivro;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
    
    
}
