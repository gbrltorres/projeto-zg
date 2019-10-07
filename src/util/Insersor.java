package util;

import model.ItemVenda;
import model.ListaProduto;
import model.Produto;

public class Insersor { 
	
	public void inserirItemVenda(String nomeItem, int quantidadeItem, ItemVenda itemVenda) {
		ListaProduto produtos = ListaProduto.getInstance();
		for(Produto p:produtos.getLista()) {
			if(p.getNome().equals(nomeItem)) { //se o nome do produto for igual à string nome, insere produto no item passado por parâmetro
				itemVenda.setProduto(p);
			}
		}
		itemVenda.setQuantidade(quantidadeItem);
		Calculador calculador = new Calculador();
		double precoTotalItem = calculador.calculaPrecoItem(itemVenda.getProduto(), quantidadeItem);
		itemVenda.setPreco(precoTotalItem);
	}
	
}
