package pucrs.myflight.modelo;

public class Aeronave {
	private String codigo;
	private String descricao;
	private String capacidade;
	
	public Aeronave(String codigo, String descricao, String capacidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public String toString() {
		return codigo + " - " + descricao + " (" + capacidade + ")";
	}
}
