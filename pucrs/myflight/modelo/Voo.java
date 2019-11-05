package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public abstract class Voo {

	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

	private LocalDateTime datahora;
	private Status status;

	public Voo( LocalDateTime dh ) {
		this.datahora = dh;
		this.status = Status.CONFIRMADO; // default é confirmado
	}

	public LocalDateTime getDataHora() {

		return this.datahora;

	}

	public abstract Duration getDuracao();

	public abstract Rota getRota();
	
	public void setStatus(Status n) {
		this.status = n;
	}

	public Status getStatus(){
		return this.status;
	}

    public abstract String toString();


	public String formatDuration(Duration d){
		int s = (int) d.getSeconds();
		String ret = s / 3600 + ":" + (s % 3600) / 60 + ":" + (s % 60);
		return ret;
	}
}

