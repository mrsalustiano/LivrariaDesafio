package com.qintess.Livraria;

import java.util.Scanner;

import com.qintess.Livraria.Relatorios.LivrosMaisVendidosRelatorio;
import com.qintess.Livraria.Relatorios.MaiorQuantidadeDeComprasRelatorio;

public class LivrariaRelatorioAPP {

	public static void main(String[] args) {
		int op = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a Opção Desejada\n" + "1 - Livros Mais Vendidos\n" + "2 - Maior numero de Compras");
		System.out.print("Opção : ");
		op = sc.nextInt();

		if (op == 1) {
			LivrosMaisVendidosRelatorio livrosRel = new LivrosMaisVendidosRelatorio();
			livrosRel.mostrar();
		} else if (op == 2) {
			MaiorQuantidadeDeComprasRelatorio comprasRel = new MaiorQuantidadeDeComprasRelatorio();
			comprasRel.Mostrar();
		} else {
			System.out.println("Opção Inválida");
		}
		sc.close();
	}

}
