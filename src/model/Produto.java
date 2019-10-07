package model;

public class Produto {
	private String nome;
	private double precoUnitario;
	private String descricao;
	
	public Produto(String nome, double precoUnitario, String descricao) {
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getPrecoPromocional() {
		return descricao;
	}

	public void setPrecoPromocional(String precoPromocional) {
		this.descricao = precoPromocional;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", precoUnitario=" + precoUnitario + ", descricao=" + descricao + "]";
	}
	
	
}
