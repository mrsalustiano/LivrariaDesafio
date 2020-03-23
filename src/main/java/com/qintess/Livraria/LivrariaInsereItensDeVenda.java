package com.qintess.Livraria;

import java.util.Scanner;

import com.qintess.Livraria.Controller.InsereItensDeVenda;
import com.qintess.Livraria.Controller.ListaLivros;
import com.qintess.Livraria.Controller.ListaVendas;

public class LivrariaInsereItensDeVenda {

	public static void main(String[] args) {
//		ListaVendas venda = new ListaVendas();
//		venda.listarVendas();
		
//		ListaItensDeVendaOriginal original = new ListaItensDeVendaOriginal();
//		original.listar();
		int idvenda;
		int idlivro;
		double subtotal;
		int quantidade;
		double valor;
		Scanner sc = new Scanner(System.in);
		
		ListaVendas venda = new  ListaVendas();
		venda.listarVendas();
		System.out.print("Digite o codigo da Venda para inserir o item  ");
		idvenda = sc.nextInt();
		
		
		ListaLivros livros = new ListaLivros();
		livros.listarLivros();
		System.out.print("Digite o codigo do livro para inserir o item  ");
		idlivro = sc.nextInt();
		
		System.out.print("Digite o valor do livro para inserir o item  ");
		valor = sc.nextDouble();
		
		System.out.print("Digite a quantidade de livros para inserir o item  ");
		quantidade = sc.nextInt();
		subtotal = quantidade * valor;
		
		System.out.println(quantidade);
		InsereItensDeVenda insere = new InsereItensDeVenda();
		insere.insereItem(idvenda, idlivro, subtotal, quantidade);
		System.out.println("Registro Gravado com sucesso");
		
		ListaVendas itens = new ListaVendas();
		itens.listarVendas();
		
		// Seleciona idvenda e salva em variavel
		// seleciona livro e salva
		// seleciona quantidade e salva
		// pega o valor do livro  salvo anterior e multiplica pela quantidade
		sc.close();
		
	}

}
