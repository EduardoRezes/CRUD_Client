package br.com.ifpr.gerenciador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.com.ifpr.dao.DaoClient;
import br.com.ifpr.modelo.Cliente;

public class GerenciadorCliente {
	Scanner scanner;
	DaoClient daoCliente;
	
	public GerenciadorCliente(){
		scanner = new Scanner(System.in);
		daoCliente = new DaoClient();
	}
	
	public void menu(){
		int opcao = -1;
		
		while(opcao != 0){
			System.out.println("--------------------------------------------------------------");
			System.out.println("-----------------GERENCIAMENTO DE CLIENTES--------------------");
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Alterar");
			System.out.println("[3] Excluir");
			System.out.println("[4] Consultar");
			System.out.println("[5] Listar todos");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.println("--------------------------------------------------------------\n");
			try{
				opcao = Integer.parseInt(scanner.nextLine());	
			} catch (Exception e) {
				System.out.println("Erro! \nInforme um número inteiro");
			}			

			if(opcao == 1){
				cadastrar();
			}else if(opcao == 2){
				alterar();
			}else if(opcao == 3){
				excluir();
			}else if(opcao == 4){
				consultar();
			}else if(opcao == 5){
				listarTodos();
			}else if(opcao != 0){
				System.out.println("Opção inválida!");
			}
		}
	}
	
	public void cadastrar(){
		Cliente cliente = new Cliente();
		
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("----------------------Cadastro de Cliente-----------------------");
		System.out.println("Nome: ");
		cliente.setNome(scanner.nextLine());
		System.out.println("Email: ");
		cliente.setEmail(scanner.nextLine());
		System.out.println("Data de Nascimento: ");
		cliente.setDataNascimento(scanner.nextLine());
		System.out.println("Telefone: ");
		cliente.setTelefone(Long.parseLong(scanner.nextLine()));
		
		boolean inserido = daoCliente.inserir(cliente);
		if(inserido){
			System.out.println("Inserido com sucesso!");
		}
	}

	private void listarTodos(){
		ArrayList<Cliente> resultado = daoCliente.buscarTodos();
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("-----------------------Clientes cadastrados---------------------");
		Iterator<Cliente> itClient = resultado.iterator();
		while(itClient.hasNext()){
			Cliente c = itClient.next();
			System.out.println("Email: " + c.getEmail()
				+ ", Nome: " + c.getNome()
				+ ", Data de Nascimento: " + c.getDataNascimento()
				+ ", Telefone: " + c.getTelefone()
				+ ", Codigo: " + c.getCodigo());
		}
	}
	
	public void excluir(){
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("---------------------Exclusão de Cliente------------------------");
		System.out.println("Código: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		int qtde = daoCliente.excluir(codigo);

		if(qtde > 0){
			System.out.println("Excluído com sucesso!");
		}else{
			System.out.println("Não encontrado...");
		}
	}
	public void consultar(){
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("---------------------Consulta de Cliente------------------------");
		System.out.println("Código: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		Cliente c = daoCliente.consultar(codigo);

		if(c != null){
			System.out.println("Dados do Cliente");
			System.out.println("Email: " + c.getEmail());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Data de Nascimento: " + c.getDataNascimento());
			System.out.println("Telefone: " + c.getTelefone());
			System.out.println("Código: " + c.getCodigo());
		}else{
			System.out.println("Nao encontrado...");
		}
	}

	private void alterar(){
		System.out.println("--------------------------------------------------------------");
		System.out.println("------------------Alteração de Cliente------------------------");
		System.out.println("Código:");
		int codigo = Integer.parseInt(scanner.nextLine());

		Cliente c = daoCliente.consultar(codigo);
		if(c != null){
			System.out.println("Codigo: [" + c.getCodigo() + "]");
			System.out.println("Nome: [" + c.getNome() + "]");
			String nome = scanner.nextLine().trim();
			if(!nome.isEmpty()){
				c.setNome(nome);
			}
			System.out.println("Email: [" + c.getEmail() + "]");
			String email = scanner.nextLine().trim();
			if(!email.isEmpty()){
				c.setEmail(email);
			}
			System.out.println("Data de Nascimento: [" + c.getDataNascimento() + "]");
			String dataNascimento = scanner.nextLine().trim();
			if(!dataNascimento.isEmpty()){
				c.setDataNascimento(dataNascimento);
			}
			System.out.println("Telefone: [" + c.getTelefone() + "]");
			String telefone = scanner.nextLine().trim();
			if(!telefone.isEmpty()){
				c.setTelefone(Long.parseLong(telefone));
			}
			int qtdeAlterado = daoCliente.alterar(c);
			if(qtdeAlterado > 0){
				System.out.println("Atualizado!");
			}
		}else{
			System.out.println("Não encontrado...");
		}
	}
}
