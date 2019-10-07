package model;

import java.util.ArrayList;
import java.util.List;

public class ListaVenda {
	private int id;
	private List<ItemVenda> itens;
	private double precoTotal;

	public ListaVenda() {
		itens = new ArrayList<ItemVenda>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	@Override
	public String toString() {
		return "ListaVenda [id=" + id + ", itens=" + itens + ", precoTotal=" + precoTotal + "]";
	}
	
	
}
