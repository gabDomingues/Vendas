package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Item;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do cliente: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String emailCliente = sc.nextLine();
		System.out.print("Data de Nascimento(DD/MM/AAAA): ");
		String dataNascimento = sc.nextLine();
		LocalDate nascimentoCliente = LocalDate.parse(dataNascimento, fmt);
		
		Cliente c1 = new Cliente(nomeCliente, emailCliente, nascimentoCliente);
		
		System.out.println("Dados do Pedido: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Pedido p1 = new Pedido(LocalDateTime.now(), StatusPedido.valueOf(status), c1);
		
		System.out.print("Quantidade de Itens: ");
		int n  = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Dados do Item #" + (i+1));
			System.out.print("Nome: ");
			String nomeProduto = sc.nextLine();
			System.out.print("Preco: ");
			double precoProduto = sc.nextDouble();
			System.out.println("Quantidade: ");
			int qtd = sc.nextInt();
			Produto p  = new Produto(nomeProduto, precoProduto);
			Item item = new Item(qtd, p);
			p1.addItem(item);
			
		}
		
		System.out.println(p1);
		
		

		sc.close();
	}

}
