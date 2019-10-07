package util;

import model.Produto;

public class Calculador {

	public double calculaPrecoItem(Produto produto, int quantidade) {
		if(produto.getPrecoPromocional().equals("preço promocional, 3 por 200")) 
			return (quantidade % 3) * produto.getPrecoUnitario() + quantidade / 3 * 200; 
		else if(produto.getPrecoPromocional().equals("preço promocional, 2 por 45"))
			return (quantidade % 2) * produto.getPrecoUnitario() + quantidade / 2 * 45;
		else if(produto.getPrecoPromocional().equals("preço promocional, leve 3 pague 2"))
			return (quantidade % 3) * produto.getPrecoUnitario() + quantidade / 3 * (produto.getPrecoUnitario() * 2);
		else
			return produto.getPrecoUnitario() * quantidade;
	}
}

