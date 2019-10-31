package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
    }
    
    public Voo(Rota rota, Duration duracao){
        this.rota = rota;
        this.duracao = duracao;
        this.datahora = LocalDateTime.of(2016, Month.AUGUST, 12, 12, 00, 00);
        this.status = Status.CONFIRMADO;
    }
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

    @Override
    public String toString() {
        return super.toString()+ "Rota: " + rota + "Data  e hora: " + datahora + "Duracao: "+ duracao;
    }

}



/*import java.time.Duration;
import java.time.LocalDateTime;

//A Classe Voo é abstrata, ou seja, não pode-se criar objetos do tipo dela,
// mas pode-se fazer como é feito na App chmar de forma estática a classe
// e criar de forma dinâmica uma instanceof VooVariasEscalas
public abstract class Voo {

    public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

    private LocalDateTime datahora;
    // private Duration duracao; - será calculado
    // private Rota rota; não é mais útil nessa classe
    private Status status;

    public Voo(LocalDateTime datahora) {
        //this.rota = rota;
        this.datahora = datahora;
        //this.duracao = duracao;
        this.status = Status.CONFIRMADO; // default é confirmado
    }

    public abstract Rota getRota();

    // método removido, pois não é mais util aqui
    //public Rota getRota() {
    //    return rota;
    //}

    public LocalDateTime getDatahora() {
        return datahora;
    }

    //public abstract Duration getDuracao();

    // método removido, pois não é mais util aqui, pois será calculado
    //public Duration getDuracao() {
    //    return duracao;
    //}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status novo) {
        this.status = novo;
    }

    @Override
    public String toString(){
        return "Data: " + datahora + "\nStatus: " + status;
    }
}*/
