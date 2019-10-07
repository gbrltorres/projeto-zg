package teste_leitor;

import java.io.File;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.VendaDao;
import input.Leitor;
import model.ItemVenda;
import model.ListaProduto;
import model.ListaVenda;

public class TesteJUnit {
	VendaDao vd = new VendaDao();
	
	@Before
	public void init() throws SQLException {
		vd.deleteRegistros();
	}
	
	@Test
	public void testaQuantidadeProdutos(){
		File file = new File("./resources/produtos");
		Leitor leitor = new Leitor();
		ListaProduto produtos = ListaProduto.getInstance();
		produtos = leitor.leiaProduto(file);
		Assert.assertEquals(4, produtos.getLista().size());
	}

	@Test
	public void testaPrecoTotalVenda() throws SQLException {
		File file = new File("./resources/venda");
		Leitor leitor = new Leitor();
		ListaVenda listaVenda = new ListaVenda();
		listaVenda = leitor.leiaListaVenda(file);
		double precoTotal = 0;
		for(ItemVenda item: listaVenda.getItens()) {
			precoTotal += item.getPreco();
		}
		Assert.assertEquals(395, precoTotal, 0);
		Assert.assertEquals(1, vd.insereRegistros(listaVenda.getItens()), 0);
	}
	
}
