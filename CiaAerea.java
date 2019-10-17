package pucrs.myflight.modelo;

public class CiaAerea {
	private String codigo;
	private String nome;
	
	public CiaAerea(String latam) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}


	@Override
	public String toString() {
		return codigo + " (" + nome + ")";
	}
}

