package entities;



public class Item {
	
	private Integer quantidade;
	private Double preco;
	
	private Produto produto;
	
	public Item() {

	}

	
	public Item(Integer quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
		this.subTotal();
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double subTotal() {
		double soma = 0.0;
		for( int i = 0; i < this.getQuantidade(); i++) {
			soma+= this.getProduto().getPreco();
		}
		this.setPreco(soma);
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getProduto().getNome() + ", ");
		sb.append("Quantidade: " + this.getQuantidade() + ", ");
		sb.append("Subtotal= R$ " + String.format("%.2f", this.getPreco()));
		return sb.toString();
		
	}
	
}	
