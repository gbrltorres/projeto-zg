package model;

public class ItemVenda {
	private int quantidade;
	private Produto produto;
	private double preco;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ItemVenda [quantidade=" + quantidade + ", produto=" + produto + ", preco=" + preco + "]";
	}
	
	
}
