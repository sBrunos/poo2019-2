package pucrs.myflight.modelo;

public class Aeronave implements Imprimivel{

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

	public void getTotalCias() {
		System.out.println(codigo + " - " + descricao);
	}

	@Override
	public String toString() {
		return codigo + " - " + descricao + " (" + capacidade + ")";
	}

	@Override
	public void imprimir() {
		System.out.println(toString());
	}

}
