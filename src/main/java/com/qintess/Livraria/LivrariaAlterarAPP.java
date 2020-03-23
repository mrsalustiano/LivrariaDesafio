package com.qintess.Livraria;

import java.util.Scanner;

import com.qintess.Livraria.Controller.AtualizarItensDeVenda;
import com.qintess.Livraria.Controller.ListaLivros;
import com.qintess.Livraria.Controller.ListaItensDeVenda;

public class LivrariaAlterarAPP {

	public static void main(String[] args) {
		AtualizarItensDeVenda atualiza = new AtualizarItensDeVenda();
		ListaLivros livros = new ListaLivros();

		Scanner sc = new Scanner(System.in);

		int item, op;
		ListaItensDeVenda lista = new ListaItensDeVenda();
		lista.listar();
		System.out.print("Digite o Identificador (IDItemVenda) do item de Venda a ser Alterado : ");
		item = sc.nextInt();
		System.out.println("Você escolheu o Item identificado com o ID " + item);
		System.out.println("1 - Livro\n" + "2 - Quantidade\n" + "3 - Subtotal");
		System.out.println("Digite 1 a 3 o item a ser Alterado");
		op = sc.nextInt();

		if (op == 1) {
			int livro = 0;
			System.out.println("Escolheu Livros");
			livros.listarLivros();
			System.out.print("Escolha o id do novo livro :");
			livro = sc.nextInt();

			if (atualiza.AtualizarLivro(livro, item)) {
				System.out.println("Atualizado com Sucesso");
				lista.listar();
			} else {
				System.out.println("Erro ao atualizar");
			}

		} else if (op == 2) {
			int qtd = 0;
			System.out.println("Escolheu Quantidade");
			ListaItensDeVenda itens = new ListaItensDeVenda();
			itens.listar();
			System.out.print("Digite a nova quantidade de livros :");
			qtd = sc.nextInt();
			if (atualiza.AtualizarQuantidade(qtd, item)) {
				System.out.println("Atualizado com Sucesso");
				lista.listar();

			} else {
				System.out.println("Erro ao atualizar");
			}

		} else if (op == 3) {
			double subtotal = 0.0;
			System.out.println("Escolheu subtotal");
			ListaItensDeVenda itens = new ListaItensDeVenda();
			itens.listar();
			System.out.println("Digite o valor para novo o subtotal : ");
			subtotal = sc.nextDouble();
			if (atualiza.AtualizarSubtotal(subtotal, item)) {
				System.out.println("Atualizado com Sucesso");
				lista.listar();

			} else {
				System.out.println("Erro ao atualizar");
			}

		} else {
			System.out.println("Escoha inválida");
		}

		sc.close();

	}

}
