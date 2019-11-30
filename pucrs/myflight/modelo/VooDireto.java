package pucrs.myflight.modelo;
import java.lang.Math;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class VooDireto extends Voo {

	private Rota rota;

	public VooDireto(Rota rota, LocalDateTime dh) {
		super(dh);
		this.rota = rota;
		this.setStatus(Status.CONFIRMADO);
	}

	public Rota getRota() {
		return rota;
	}

	@Override
	public void setStatus(Status n) {
		super.setStatus(n);
	}

	public Duration getDuracao() {
		final int R = 6371;

		double oLat= rota.getOrigem().getLocal().getLatitude();
		double oLon= rota.getOrigem().getLocal().getLongitude();
		Geo geo = new Geo (oLat, oLon);

		double distancia =  geo.distanciaAtual(rota.getDestino().getLocal());

		distancia = Math.acos(distancia);
		distancia = Math.toDegrees(distancia);
		distancia = distancia * 60 * 1.1515 * 1.609344;

		double tempo = 805 / distancia;
		long segundos = (long) (tempo * 3600);

		Duration duracao = Duration.ofSeconds(segundos);
		duracao = duracao.plusMinutes(30);

		return duracao;
	}
	
    @Override
    public String toString() {
		try{
			return "Rota: " + rota + " Data  e hora: " + super.getDataHora().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " Duracao: "+super.formatDuration(this.getDuracao());
		}
			catch (Exception e) {
			return "Houve um problema ao acessar a rota.";
		}
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
