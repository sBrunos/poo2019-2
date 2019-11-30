package pucrs.myflight.modelo;

public class Aeroporto implements Comparable<Aeroporto>{
	private String codigo;
	private String nome;
	private Geo loc;
	
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Geo getLocal() {
		return loc;
	}

	@Override
	public String toString() {
		return " codigo do aeroporto: " + codigo + " nome: " + nome + " [" + loc.toString() + "]";
	}

	@Override
	public int compareTo(Aeroporto outro) {
		return nome.compareTo(outro.nome);
	}
}
