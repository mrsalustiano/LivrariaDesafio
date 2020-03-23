package com.qintess.Livraria;

import java.util.Scanner;

import com.qintess.Livraria.Controller.ApagarItensDeVenda;
import com.qintess.Livraria.Controller.ListaItensDeVenda;

public class LivrariaApagaItemsDeVenda {

	public static void main(String[] args) {
		int escolha = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Lista de Itens de Venda \n\r");
		
		ListaItensDeVenda listar = new ListaItensDeVenda();
		listar.listar();
		System.out.print("\n\r");
		System.out.print("Digite o Codigo de Item de Venda : ");
		escolha = sc.nextInt();
		ApagarItensDeVenda apagar = new ApagarItensDeVenda();
		if (apagar.apagar(escolha)) {
			System.out.println("Registro Apagado Com sucesso");
		} else{
			System.out.println("Falha ao Apagar Registro");
		}
		System.out.println("O Item Escolhido foi " + escolha);
		
		sc.close();
		
		
		
	}

}
