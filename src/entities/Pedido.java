package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime momento;
	private StatusPedido status;
	
	private List<Item> itens = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido() {
		
	}

	
	
	public Pedido(LocalDateTime momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}



	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = LocalDateTime.now();
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<Item> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(Item item) {
		itens.add(item);
	}
	
	public void removerItem(Item item) {
		itens.remove(item);
	}
	
	public double total() {
		double soma = 0.0;
		for(Item i : itens) {
			soma+= i.getPreco();
		}
		return soma;
	}	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DOS PEDIDOS:\n");
		sb.append("Data: " + fmt.format(this.momento) + "\n");
		sb.append("Status do Pedido: " + this.getStatus() + "\n");
		sb.append("Cliente: " + this.getCliente() );
		sb.append("LISTA DE ITENS: \n" );
		for( Item i : itens) {
			sb.append(i + "\n");
		}
		sb.append("TOTAL = R$ " + String.format("%.2f", this.total()));
		return sb.toString();
	}
	
	
	
}
