package model;

import java.util.ArrayList;
import java.util.List;

public final class ListaProduto {
	private static ListaProduto instance = new ListaProduto();
	private List<Produto> lista;
	
	private ListaProduto() {
		lista = new ArrayList<Produto>();
	}
	
	public static ListaProduto getInstance(){
        return instance;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	
}
