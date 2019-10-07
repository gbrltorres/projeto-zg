package input;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ItemVenda;
import model.ListaProduto;
import model.ListaVenda;
import model.Produto;
import util.Insersor;

public class Leitor {
	
	public static String readFile(File file) throws IOException {
		Path path = file.toPath();
		byte[] bytes = Files.readAllBytes(path);
		return new String(bytes, StandardCharsets.UTF_8);
	}
	
	public void insereProdutos(String fileContent) {
		Pattern pattern = Pattern.compile("(?m)^([\\wÀ-ú\\s]+)\\spreço unitário\\s([\\d.]+)[\\s]?([\\wÀ-ú ,]+)?");
		Matcher matcher = pattern.matcher(fileContent);
		ListaProduto produtos = ListaProduto.getInstance();
		while(matcher.find()) {
			String nome = matcher.group(1);
			double precoUnitario = Double.parseDouble(matcher.group(2));
			String descricao = "";
			if(matcher.group(3) != null) //não possua preço promocional
			{
				descricao = matcher.group(3);
			}
			Produto produto = new Produto(nome, precoUnitario, descricao);
			produtos.getLista().add(produto);
		}
	}
	
	public ListaVenda insereItemVenda(String fileContent) {
		Pattern pattern = Pattern.compile("(?m)^([\\d+])\\sx\\s([\\w ]+)$");
		Matcher matcher = pattern.matcher(fileContent);
		ListaVenda venda = new ListaVenda();
		while(matcher.find()) {
			ItemVenda itemVenda = new ItemVenda();
			int quantidadeItem = Integer.parseInt(matcher.group(1));
			String nomeItem = matcher.group(2);
			Insersor insersor = new Insersor();
			insersor.inserirItemVenda(nomeItem, quantidadeItem, itemVenda);
			venda.getItens().add(itemVenda);
		}
		return venda;
	}
	
	public int getNumeroVenda(String fileContent) {
		Pattern pattern = Pattern.compile("Venda\\s([\\d]+)");
		Matcher matcher = pattern.matcher(fileContent);
		matcher.find();
		return Integer.parseInt(matcher.group(1));
	}
	
	public double getPrecoTotalVenda(String fileContent) {
		Pattern pattern = Pattern.compile("Total\\s([\\d,]+)");
		Matcher matcher = pattern.matcher(fileContent);
		matcher.find();
		String precoTotal = matcher.group(1).replace(",", ".");
		return Double.parseDouble(precoTotal);
	}
	
	public ListaProduto leiaProduto(File file) {
		ListaProduto produtos = ListaProduto.getInstance();
		try {
			String fileContent = readFile(file);
			insereProdutos(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
	}
	
	public ListaVenda leiaListaVenda(File file) {
		ListaVenda venda = new ListaVenda();
		try {
			String fileContent = readFile(file);
			venda = insereItemVenda(fileContent);
			venda.setId(getNumeroVenda(fileContent));
			venda.setPrecoTotal(getPrecoTotalVenda(fileContent));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return venda;
	}
}
