package br.com.ifpr.main;

import java.util.Scanner;

import br.com.ifpr.gerenciador.GerenciadorCliente;

public class Menu {
	public static void main(String[] args) {
		Menu sis = new Menu();
		sis.menu();
	}
	
	public void menu(){
		int opcao = -1;
		Scanner scanner = new Scanner(System.in);
		while(opcao != 0){
			System.out.println("--------------------------------------------------------------");
			System.out.println("");
			System.out.println("------------------------MENU PRINCIPAL------------------------");
			System.out.println("[1] Gerenciar Clientes");
			System.out.println("[0] Sair");
			System.out.println("-------------------------------------------------------------- \n");
			try{
				opcao = Integer.parseInt(scanner.nextLine());		
			} catch (Exception e) {
				System.out.println("Opção Invalida.");
			}
			
			if(opcao == 1){
				GerenciadorCliente geradorCliente = new GerenciadorCliente();
				geradorCliente.menu();
			}else if(opcao == 0){
				System.out.println("Saindo");
			}else{
				System.out.println("Opção invalida!");
			}
		}	
	}	
}